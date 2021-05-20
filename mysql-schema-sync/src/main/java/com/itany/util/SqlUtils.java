package com.itany.util;

import java.util.Objects;

/**
 * Author：耿常安
 * Date：2021-03-13-10:06
 * Description：<描述>
 */
public class SqlUtils {

    public static String nullableSet(String nullable){
        if("NO".equals(nullable)){
            return "not null";
        }
        return "";
    }

    public static String defaultSet(String defaultValue){
        if(Objects.isNull(defaultValue)){
            return "";
        }

        return "default '" + defaultValue + "'";
    }

    public static String commentSet(String comment){
        if(Objects.isNull(comment)){
            return "";
        }
        return "comment '" + comment + "'";
    }

    public static String uniqueSet(int nonUnique){
        switch (nonUnique){
            case 0:return "UNIQUE";
            default:return "";
        }
    }
}
