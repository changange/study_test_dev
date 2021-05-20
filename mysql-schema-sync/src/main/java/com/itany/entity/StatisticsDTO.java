package com.itany.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * Author：耿常安
 * Date：2021-03-13-11:51
 * Description：<描述>
 */

@Data
@Builder
public class StatisticsDTO {
    private String tableSchema; //数据库名
    private String tableName;   //表名
    private String indexName;   //索引名
    private List<String> columns;  //列名

    private String nonUnique;      //判断索引是不是唯一属性，，0是唯一，1是主键
}
