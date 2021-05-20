package com.itany.mvc.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Author：耿常安
 * Date：2021-03-06-21:23
 * Description：<描述>
 */

@Data
@ConfigurationProperties(prefix = "ss")     //和配置文件的ss对应
@Component
public class Student {
    private int id;
    private String name;

}
