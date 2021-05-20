package com.itany.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Author：耿常安
 * Date：2021-03-12-11:04
 * Description：<描述>
 */
@Data
@EqualsAndHashCode(exclude = "engine")  //equals和hashcode不包含engine
public class TableDO {
    private String tableSchema;      //数据库
    private String tableName;       //表名
    private String engine;          //引擎

}
