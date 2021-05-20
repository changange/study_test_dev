package com.itany.entity;

import lombok.*;

/**
 * Author：耿常安
 * Date：2021-03-11-10:40
 * Description：<描述>
 */
@Data
@AllArgsConstructor     //所有参数构造器
@NoArgsConstructor      //无参构造器
@RequiredArgsConstructor    //构造器，属性上带有@NonNull的生成的构造器
public class RetMsg {
    @NonNull       //这个参数不能为空
    private String resultNo;
    @NonNull
    private String msg;
    private Object data;

    public static RetMsg success(Object data){
        return new RetMsg("000","ok",data);
    }

    public static RetMsg success(){
        return success(null);
    }

    public static RetMsg error(String no, String msg){
        return new RetMsg(no,msg);
    }
    public static RetMsg error(){
        return new RetMsg("111","failed");
    }
}
