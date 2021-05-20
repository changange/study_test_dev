package com.itany.factory;

import com.itany.entity.ConnectInfo;
import org.apache.ibatis.datasource.pooled.PooledDataSource;

import javax.sql.DataSource;

/**
 * Author：耿常安
 * Date：2021-03-12-11:07
 * Description：<描述>
 */
public class LocalDataSourceFactory {

    //和xml文件里的 pool  一样  PooledDataSource
    public static DataSource getPooledDataSource(ConnectInfo connectInfo){
        PooledDataSource pooledDataSource = new PooledDataSource();
        pooledDataSource.setUrl(connectInfo.getUrl());
        pooledDataSource.setDriver(connectInfo.getDriver());
        pooledDataSource.setUsername(connectInfo.getUsername());
        pooledDataSource.setPassword(connectInfo.getPassword());

        return pooledDataSource;
    }
}
