package com.itany.mvc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author：耿常安
 * Date：2021-03-06-20:59
 * Description： 返回json字符串
 */

@Data
@AllArgsConstructor     //全部参数构造器
@NoArgsConstructor      //无参构造器
public class ResultMsg {

    public static final String SUCCESS_NO="0000";
    public static final String SUCCESS_MSG="success";

    private String no;

    private String msg;
    private Object data;

    public ResultMsg(String no, String msg) {
        this.no = no;
        this.msg = msg;
    }

    public static ResultMsg success(){
        return success(null);
    }

    //重载
    public static ResultMsg success(Object data){
        return new ResultMsg(SUCCESS_NO,SUCCESS_MSG,data);
    }

    public static ResultMsg error(String no, String msg){
        return new ResultMsg(no,msg);
    }
}
