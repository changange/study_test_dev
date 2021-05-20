package com.itany.mapper;

import com.itany.entity.TableDO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Author：耿常安
 * Date：2021-03-12-11:08
 * Description：<描述>
 */
public interface TableMapper extends BaseMapper {

    @Select("select table_schema,table_name,engtne from information_schema.tables")
    List<TableDO> findAll();

    @Select("select table_schema,table_name,engine from information_schema.tables where table_schema=#{dbName}")
    List<TableDO> findByDbName(String dbName);      //两个参数的时候要写 @Param

}