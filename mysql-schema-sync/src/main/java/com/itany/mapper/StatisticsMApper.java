package com.itany.mapper;

import com.itany.entity.StatisticsDO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author：耿常安
 * Date：2021-03-12-11:08
 * Description：<描述>
 */
@Repository
public interface StatisticsMApper extends BaseMapper {

    @Select("select table_schema,table_name,index_name,seq_in_index,column_name " +
            "from information_schema.statistics where table_schema=#{dbName} and table_name=#{tableName}")
    List<StatisticsDO> findByTableName(@Param("dbName") String dbName, @Param("tableName")String tableName);
}
