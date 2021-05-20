package com.itany.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    @Bean
    //从配置文件中读取spring.datasource属性，并注入给数据源的属性
    //自己配置数据源信息
    //spring.datasource:就是全局配置文件的意思
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource(){
        return new BasicDataSource();
    }
}
