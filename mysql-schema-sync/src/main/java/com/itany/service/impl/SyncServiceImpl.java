package com.itany.service.impl;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.itany.Dao.DaoFacede;
import com.itany.consts.SqlConst;
import com.itany.entity.*;
import com.itany.factory.LocalSqlSessionFactory;
import com.itany.mapper.ColumnMapper;
import com.itany.mapper.SchemaMapper;
import com.itany.mapper.StatisticsMApper;
import com.itany.mapper.TableMapper;
import com.itany.service.SyncService;
import com.itany.util.SqlUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Author：耿常安
 * Date：2021-03-11-10:39
 * Description：<描述>
 */
@Service
public class SyncServiceImpl implements SyncService {

    //这两个注入不进来   因为没有使用springboot自己的mybatis
    //@Autowired
    //private ColumnMapper columnMapper;
    //@Autowired
    //private StatisticsMApper statisticsMApper;

    @Override
    public void syncInstance(SyncInfo syncInfo) {
        ConnectInfo srcInfo= syncInfo.getSrcInfo();    //源连接信息
        ConnectInfo dstInfo= syncInfo.getDstInfo();     //目标连接信息
        List<SchemaDO> srcDbs = DaoFacede.ofMapper(srcInfo, SchemaMapper.class, m -> m.findAll());
        List<SchemaDO> dstDbs = DaoFacede.ofMapper(dstInfo, SchemaMapper.class, m -> m.findAll());

        //src有 dst没有  新建库 之后交给 syncDB
        //src有 dst有  diff
        Set<SchemaDO> addDbs = Sets.difference(new HashSet<>(srcDbs), new HashSet<>(dstDbs)).immutableCopy();
        addDbs.stream()
                .filter(db->!SqlConst.MYSQL_SYS_DB.contains(db.getSchemaName()))        //排除不同步的系统
                .filter(db->!syncInfo.getExcludeDbs().contains(db.getSchemaName()))    //排除不同步的库
                .forEach(db->{
                    String sql = DaoFacede.getDBSql(srcInfo,db.getSchemaName());
                    DaoFacede.execSql(dstInfo,sql);
                });

        srcDbs.stream()
                .filter(db->!SqlConst.MYSQL_SYS_DB.contains(db.getSchemaName()))
                .forEach(db->{
                    SyncDBInfo syncDBInfo = new SyncDBInfo();
                    syncDBInfo.setSrcInfo(srcInfo);
                    syncDBInfo.setDstInfo(dstInfo);
                    syncDBInfo.setDbName(db.getSchemaName());
                });
    }

    @Override
    public void syncDB(SyncDBInfo syncDBInfo) {
        ConnectInfo srcInfo= syncDBInfo.getSrcInfo();    //源连接信息
        ConnectInfo dstInfo= syncDBInfo.getDstInfo();     //目标连接信息
        String dbName = syncDBInfo.getDbName();          //数据库

        //获取所有表
        List<TableDO> srcTables = DaoFacede.ofMapper(srcInfo, TableMapper.class, m -> m.findByDbName(dbName));
        List<TableDO> dstTable = DaoFacede.ofMapper(dstInfo, TableMapper.class, m -> m.findByDbName(dbName));

        //src有 dst没有，直接建表
        Set<TableDO> addTables = Sets.difference(new HashSet<>(srcTables), new HashSet<>(dstTable)).immutableCopy();
        createTable(srcInfo,dstInfo,addTables);

        //src有   dst有   就diff
        //intersection  求交集（他俩都有）
        Set<TableDO> difftables = Sets.intersection(new HashSet<>(srcTables), new HashSet<>(dstTable)).immutableCopy();
        difftables.stream().forEach(tableDO -> {
            SyncTableInfo syncTableInfo = new SyncTableInfo();
            syncTableInfo.setSrcInfo(srcInfo);
            syncTableInfo.setDstInfo(dstInfo);
            syncTableInfo.setDbName(dbName);
            syncTableInfo.setTableName(tableDO.getTableName());
        });
    }

    private void createTable(ConnectInfo srcInfo, ConnectInfo dstInfo, Set<TableDO> addTables) {
        //show create table tb.tb_user;     查看建表语句
        addTables.stream()
                .forEach(tableDO -> {
                    String tableSql = DaoFacede.getTableSql(srcInfo, tableDO.getTableSchema(), tableDO.getTableName());
                    String useSql = "use " + tableDO.getTableSchema();
                    DaoFacede.execSql(dstInfo, Lists.newArrayList(useSql, tableSql));
                });
    }

    @Override
    /**
     * 同步表
     */
    public void synTable(SyncTableInfo syncTableInfo) {

        //列
        syncColumn(syncTableInfo);
        //索引
        syncIndex(syncTableInfo);
    }

    /**
     * 同步列
     * @param syncTableInfo
     */
    private void syncColumn(SyncTableInfo syncTableInfo){
        //获取元和目标的链接信息
        ConnectInfo srcInfo= syncTableInfo.getSrcInfo();    //源连接信息
        ConnectInfo dstInfo= syncTableInfo.getDstInfo();     //目标连接信息
        //获取同步的库和表
        String dbName = syncTableInfo.getDbName();          //数据库
        String tableName = syncTableInfo.getTableName();    //数据表

        //1、在src找到对应的库和表  获取字段和索引
        //自己绑定数据库信息，没有用springboot自带的mybatis
        //列的信息
        SqlSession sqlSession = LocalSqlSessionFactory.of().getSqlSession(srcInfo);
        ColumnMapper columnMapper = sqlSession.getMapper(ColumnMapper.class);
        List<ColumnDO> colums = columnMapper.findByTableName(dbName, tableName);

        colums.forEach(System.out::println);

        //2、在dst(目标)找到对应的库和表  获取字段和索引
        List<ColumnDO> dstColums = DaoFacede.ofMapper(dstInfo, ColumnMapper.class, mapper -> mapper.findByTableName(dbName, tableName));
        List<StatisticsDO> dstStatistics = DaoFacede.ofMapper(dstInfo, StatisticsMApper.class, mapper -> mapper.findByTableName(dbName, tableName));

        //3、deff
        List<ColumnDO> columnDOS = diffColumn(colums, dstColums);
        System.out.println("这是哼哼猪-------------------");
        columnDOS.forEach(x->System.out.println("diffcolumn:" +x));
        System.out.println("这是哼哼猪-------------------");

        //4、基于差异生成SQL
        List<String> sqlColumns = getSqlColumn(columnDOS);
        sqlColumns.forEach(x->System.out.println("SQLSQLSQLSQLSQL：" +x));
        //5、执行sql
        execSql(dstInfo,sqlColumns);
    }

    /**
     * 同步索引
     * @param syncTableInfo
     */
    private void syncIndex(SyncTableInfo syncTableInfo){
        //获取元和目标的链接信息
        ConnectInfo srcInfo= syncTableInfo.getSrcInfo();    //源连接信息
        ConnectInfo dstInfo= syncTableInfo.getDstInfo();     //目标连接信息
        String dbName = syncTableInfo.getDbName();          //数据库
        String tableName = syncTableInfo.getTableName();    //数据表

        //1、在src找到对应的库和表  获取字段和索引
        //自己绑定数据库信息，没有用springboot自带的mybatis
        //列的信息
        SqlSession sqlSession = LocalSqlSessionFactory.of().getSqlSession(srcInfo);
        //索引信息
        StatisticsMApper statisticsMApper = sqlSession.getMapper(StatisticsMApper.class);
        List<StatisticsDO> statisticsDOList = statisticsMApper.findByTableName(dbName, tableName);
        statisticsDOList.forEach(System.out::println);


        //2、在dst(目标)找到对应的库和表  获取字段和索引
        List<StatisticsDO> dstStatistics = DaoFacede.ofMapper(dstInfo, StatisticsMApper.class, mapper -> mapper.findByTableName(dbName, tableName));

        //test
        dstStatistics.forEach(System.out::println);

        //索引信息
        statisticsMApper = sqlSession.getMapper(StatisticsMApper.class);
        statisticsDOList = statisticsMApper.findByTableName(dbName, tableName);
        statisticsDOList.forEach(System.out::println);

        //4、基于差异生成SQL
        Map<Boolean, List<StatisticsDTO>> booleanListMap = diffStatistics(statisticsDOList, dstStatistics);

        //test
        System.out.println("==================================");
        statisticsDOList.forEach(x->System.out.println("diffstatistics:" +x));
        System.out.println("==================================");

        //好像是指生成SQL
        List<String> onlyCreateSqls = getCreateSqlStatistics(booleanListMap.get(true));//true就是新建
        System.out.println("1111111111111111111111111");
        onlyCreateSqls.forEach(System.out::println);
        System.out.println("1111111111111111111111111");

        //生成索引
        //索引只能删除再新建，不能修改
        List<String> dropSqls = getDropSqlStatistics(booleanListMap.get(false));
        List<String> createSqls = getCreateSqlStatistics(booleanListMap.get(false));

        //5、执行SQL 索引
        execSql(dstInfo,onlyCreateSqls);
        execSql(dstInfo,dropSqls);
        execSql(dstInfo,createSqls);
    }

    //-------------------找出不一样的列
    public List<ColumnDO> diffColumn(List<ColumnDO> srcColumns, List<ColumnDO> dstColumns){
        Set<ColumnDO> columnDOS = Sets.difference(new HashSet<>(srcColumns), new HashSet<>(dstColumns)).immutableCopy();//list转set

        //吧列名拿出来转换成一个集合
        Set<String> srcNames = srcColumns.stream().map(columnDO -> columnDO.getColumnName()).collect(Collectors.toSet());
        Set<String> dstNames = dstColumns.stream().map(columnDO -> columnDO.getColumnName()).collect(Collectors.toSet());
        Set<String> addNames = Sets.difference(srcNames, dstNames).immutableCopy();

        List<ColumnDO> collect = columnDOS.stream()
                .peek(columnDO -> addSet(addNames,columnDO))
                .collect(Collectors.toList());
        return collect;
    }
    public void addSet(Set<String> addNames, ColumnDO columnDo){
        if (addNames.contains(columnDo.getColumnName())){
            columnDo.setAdd(true);
        }
    }

    //-------------------找出不一样的索引
    public Map<Boolean, List<StatisticsDTO>> diffStatistics(List<StatisticsDO> srcStatistics, List<StatisticsDO> dstStatistics){
        Set<StatisticsDTO> srcDtos = fromStatisticsDOToStatisticsDTO(new HashSet<>(srcStatistics));
        Set<StatisticsDTO> dstDtos = fromStatisticsDOToStatisticsDTO(new HashSet<>(dstStatistics));
        Set<StatisticsDTO> statisticsDTOS = Sets.difference(srcDtos, dstDtos).immutableCopy();//list转set

        Set<String> srcNames = srcDtos.stream().map(dto -> dto.getIndexName()).collect(Collectors.toSet());
        Set<String> dstNames = dstDtos.stream().map(dst -> dst.getIndexName()).collect(Collectors.toSet());
        Set<String> addNames = Sets.difference(srcNames, dstNames).immutableCopy();//list转set

        Map<Boolean, List<StatisticsDTO>> collect = statisticsDTOS.stream().collect(Collectors.partitioningBy(dto -> addNames.contains(dto.getIndexName())));

        return collect;
    }
    private Set<StatisticsDTO> fromStatisticsDOToStatisticsDTO(Set<StatisticsDO> statisticsDOS){
        Map<String, List<StatisticsDO>> statisticsGroup = statisticsDOS.stream().collect(Collectors.groupingBy(s -> s.getIndexName()));
        //从DT转DTO
        return statisticsGroup.entrySet().stream()
                .map(
                        e-> {
                            StatisticsDO sdo = e.getValue().get(0);;
                            List<String> columns=e.getValue().stream()
                                    .sorted((x,y)->x.getSeqInIndex()-y.getSeqInIndex())
                                    .map(statisticsDO -> statisticsDO.getColumnName())
                                    .collect(Collectors.toList());

                            return StatisticsDTO.builder()
                                    .indexName(e.getKey())
                                    .tableName(sdo.getTableName())
                                    .tableSchema(sdo.getTableSchema())
                                    .columns(columns)
                                    .nonUnique(sdo.getNonUnique())
                                    .build();
                        })
                .collect(Collectors.toSet());
    }


    //----------生成SQL
    public List<String> getSqlColumn(List<ColumnDO> columnDOS){
        return columnDOS.stream().map(columnDO ->
                String.format(columnDO.isAdd() ? SqlConst.ADD_COLUMN_SQL : SqlConst.MODIFY_COLUMN_SQL,
                        columnDO.getTableSchema(),
                        columnDO.getTableName(),
                        columnDO.getColumnName(),
                        columnDO.getColumnType(),
                        SqlUtils.nullableSet(columnDO.getIsNullable()),
                        SqlUtils.defaultSet(columnDO.getColumnComment()),
                        SqlUtils.commentSet(columnDO.getColumnDefault()))
        )
                .collect(Collectors.toList());
    }

    public List<String> getCreateSqlStatistics(List<StatisticsDTO> statisticsDOS){

        return statisticsDOS.stream()
                .map(dto->String.format(SqlConst.ADD_INDEX_SQL,
                        dto.getTableName(),
                        dto.getTableSchema(),
                        SqlUtils.nullableSet(dto.getNonUnique()),
                        dto.getIndexName(),
                        Joiner.on(",").join(dto.getColumns())))     //根据逗号没几把听到
                .collect(Collectors.toList());
    }
    public List<String> getDropSqlStatistics(List<StatisticsDTO> statisticsDOS){

        return statisticsDOS.stream()
                .map(dto->String.format(SqlConst.DROP_COLUMN_SQL,
                        dto.getTableSchema(),
                        dto.getTableName(),
                        dto.getIndexName()))
                .collect(Collectors.toList());
    }


    //--------执行sql
    public void execSql(ConnectInfo connectInfo, List<String> sqls){
        DaoFacede.execSql(connectInfo, sqls);
    }
}
