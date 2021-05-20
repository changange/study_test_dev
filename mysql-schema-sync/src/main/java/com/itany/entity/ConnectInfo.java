package com.itany.entity;

import com.itany.util.VerifyUtil;
import lombok.Data;

/**
 * Author：耿常安
 * Date：2021-03-11-10:40
 * Description：<描述>
 */
@Data
public class ConnectInfo {
    private String url;
    private String password;
    private String username;
    //private String driver="";
    private String driver= "com.mysql.jdbc.Driver";

    //校验
    public void verify(){
        VerifyUtil.verifyAllString(url,password,password);
    }
}
