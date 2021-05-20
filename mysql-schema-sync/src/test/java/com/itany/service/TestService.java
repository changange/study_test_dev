package com.itany.service;

import com.itany.entity.ConnectInfo;
import com.itany.entity.SyncTableInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Author：耿常安
 * Date：2021-03-12-11:00
 * Description：<描述>
 */
//使用@Autowired这个注解就要使用到下面两个注解
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestService {

    @Autowired
    private SyncService syncService;
    @Test
    public void testSync(){

        /**
         * 没有用springboot自带的mybatis，用的是我们自己的mybatis，
         * 所以实现里边写的连接信息就没有交给spring管理，所以在测试里边就没有数据库的信息
         *
         * 如果我们使用springboot自己的mybatis，不写配置文件的链接信息就会报错
         */
        SyncTableInfo syncTableInfo = new SyncTableInfo();

        ConnectInfo srcInfo = new ConnectInfo();
        srcInfo.setUrl("jdbc:mysql://212.64.42.233:3307");;
        srcInfo.setUsername("root");
        srcInfo.setPassword("root");

        ConnectInfo dstInfo = new ConnectInfo();
        dstInfo.setUrl("jdbc:mysql://212.64.42.233:3306");;
        dstInfo.setUsername("root");
        dstInfo.setPassword("320517gca");

        syncTableInfo.setSrcInfo(srcInfo);
        syncTableInfo.setDstInfo(dstInfo);
        syncTableInfo.setDbName("tb");
        syncTableInfo.setTableName("tb_user");

        syncService.synTable(syncTableInfo);
    }

}
