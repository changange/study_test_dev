package com.itany.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Author：耿常安
 * Date：2021-03-11-10:40
 * Description：<描述>
 */
@Data
public class SyncInfo {
    //同步实例，不需要知道库和表
    //三个数据库就是三个实例，3个服务

    //源的连接信息
    private ConnectInfo srcInfo;
    //目标的链接信息
    private ConnectInfo dstInfo;

    //排除同步的库
    private List<String> excludeDbs= new ArrayList<>();

    public void verify(){
        srcInfo.verify();
        dstInfo.verify();
    }

}
