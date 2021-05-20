package com.itany.mapper;

import com.itany.entity.ColumnDO;
import com.itany.entity.ConnectInfo;
import com.itany.entity.SchemaDO;
import com.itany.entity.TableDO;
import com.itany.factory.LocalSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Author：耿常安
 * Date：2021-03-12-11:00
 * Description：<描述>
 */
public class TestMapper {
    private SqlSession sqlSession;

    @Before
    public void init(){
        ConnectInfo connectInfo = new ConnectInfo();
        connectInfo.setUrl("jdbc:mysql://212.64.42.233:3306");;
        connectInfo.setUsername("root");
        connectInfo.setPassword("320517gca");

        sqlSession = LocalSqlSessionFactory.of().getSqlSession(connectInfo);
    }

    @Test
    public void testSchame(){
        System.out.println("====================================================================");
        SchemaMapper mapper = sqlSession.getMapper(SchemaMapper.class);
        List<SchemaDO> all = mapper.findAll();
        all.forEach(System.out::println);
        System.out.println("----------------------------------------------------------------------");
    }

    @Test
    public void testtable(){
        System.out.println("====================================================================");
        TableMapper mapper = sqlSession.getMapper(TableMapper.class);
        List<TableDO> all = mapper.findByDbName("tb");
        all.forEach(System.out::println);
        System.out.println("----------------------------------------------------------------------");
    }

    @Test
    public void testColumn(){
        System.out.println("====================================================================");
        ColumnMapper mapper = sqlSession.getMapper(ColumnMapper.class);
        List<ColumnDO> all = mapper.findByTableName("tb","tb_user");
        all.forEach(System.out::println);
        System.out.println("----------------------------------------------------------------------");
    }
}
