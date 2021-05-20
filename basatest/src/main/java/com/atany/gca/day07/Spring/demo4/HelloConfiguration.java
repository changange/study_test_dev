package com.atany.gca.day07.Spring.demo4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author：耿常安
 * Date：2021-02-28-11:37
 * Description：<描述>
 */

/**
 * 配置类
 */
@Configuration
public class HelloConfiguration {
    //有很多bean的时候，就会加很多bean
    @Bean
    public HelloService getHello(){
        return new HelloServiceImpl();
    }
}
