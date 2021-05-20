package com.itany.util;

import com.google.common.base.Strings;

/**
 * Author：耿常安
 * Date：2021-03-11-10:38
 * Description：<描述>
 */
public class VerifyUtil {

    //验证
    public static void verifyString(String str, String msg){
        if(Strings.isNullOrEmpty(str)){
            throw new IllegalArgumentException(msg);
        }
    }

    public static void verifyAllString(String... ss){
        for(String str:ss){
            verifyString(str,"not null");
        }
    }
}

