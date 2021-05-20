package com.itany.mapper;

import com.itany.entity.SchemaDO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Author：耿常安
 * Date：2021-03-12-11:08
 * Description：<描述>
 */
public interface SchemaMapper extends BaseMapper {

    @Select("select schema_name,default_character_set_name from information_schema.schemata")
    List<SchemaDO> findAll();

    @Select("select schema_name,default_character_set_name from information_schema.schema where schema_name=#{dbName}")
    SchemaDO findByName(String dbName);
}
