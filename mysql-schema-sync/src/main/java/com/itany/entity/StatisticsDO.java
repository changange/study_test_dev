package com.itany.entity;

import lombok.Data;

/**
 * Author：耿常安
 * Date：2021-03-11-22:29
 * Description： 索引
 */
@Data
public class StatisticsDO {
    private String tableSchema; //数据库名
    private String tableName;   //表名
    private String indexName;   //索引名
    private int seqInIndex;    //字段在索引中的顺序
    private String columnName;  //列名

    private String  nonUnique;
}
