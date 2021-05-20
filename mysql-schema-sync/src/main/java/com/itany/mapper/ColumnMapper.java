package com.itany.mapper;

import com.itany.entity.ColumnDO;
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
public interface ColumnMapper extends BaseMapper {

    @Select("select table_schema,table_name,column_name,coulumn_type,column_comment,data_type,column_default,is_nullable from information_schema.columns")
    List<ColumnMapper> findAll();

    @Select("select table_schema,table_name,column_name,column_type,column_comment,data_type,column_default,is_nullable " +
            "from information_schema.columns where table_schema=#{dbName} and table_name=#{tableName}")
    List<ColumnDO> findByTableName(@Param("dbName") String dbName, @Param("tableName") String tableName);
}

