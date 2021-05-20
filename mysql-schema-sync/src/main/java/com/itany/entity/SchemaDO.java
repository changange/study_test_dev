package com.itany.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Author：耿常安
 * Date：2021-03-12-11:04
 * Description：<描述>
 */
//DO：Database Object    数据库查询的结果都放到这个里边
//VO：结果经过处理之后的数据。例如：班级id，就要转换成对应的班级展示给用户（好像和值对象有区别）

@Data
@EqualsAndHashCode(exclude = {"defaultCharacterSetName"})
public class SchemaDO {
    //SCHEMA_NAME：数据库名
    //DEFAULT_CHRACTER_SET_NAME；默认字符集
    private String schemaName;
    private String defaultCharacterSetName;
}
