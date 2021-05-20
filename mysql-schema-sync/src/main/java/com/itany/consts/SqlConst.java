package com.itany.consts;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Author：耿常安
 * Date：2021-03-13-9:05
 * Description：SQL模板
 */
public interface SqlConst {

    String MODIFY_COLUMN_SQL= "alter table `%s`.`%s` modify column %s %s %s %s";
    String ADD_COLUMN_SQL= "alter table `%s`.`%s` add column %s %s %s %s";
    String ADD_INDEX_SQL=   "alter table `%s`.`%s` add %s index %s(%s)";
    String DROP_COLUMN_SQL= "alter table `%s`.`%s` drop  index %s";

    //系统库不能被同步
    List<String> MYSQL_SYS_DB = Lists.newArrayList("information_schema","mysql","sys","perfprmace_schema");
}
