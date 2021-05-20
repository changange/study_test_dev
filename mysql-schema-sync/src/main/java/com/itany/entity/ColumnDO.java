package com.itany.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Author：耿常安
 * Date：2021-03-12-11:03
 * Description：<描述>
 */
@Data
@EqualsAndHashCode(exclude = {"isAdd"})     //生成的equals和hashcode不包括这个
public class ColumnDO {
    private String tableName;   //表名
    private String tableSchema; //数据库
    private String columnName;  //列名
    private String columnType;  //列的类型
    private String columnComment;       //注释信息
    private String dataType;            //列的数据类型
    private String columnDefault;       //列的默认值
    private String isNullable;         //是否为null

    //判断是否是新增的
    private boolean isAdd;
}