package com.itany.mvc.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Author：耿常安
 * Date：2021-03-07-14:14
 * Description：参数
 */


@Data
@Component
@PropertySource("classpath:db.properties")      //路径
@ConfigurationProperties("db")
public class DBPro {
    private String url;
    private String name;
    private String password;
    private String driver;
}
