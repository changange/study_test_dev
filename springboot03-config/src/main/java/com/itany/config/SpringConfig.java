package com.itany.config;

import com.itany.bean.Address;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author：耿常安
 * Date：2021-03-04-15:19
 * Description：<描述>
 */

//标注在类上，表示这是一个配置文件，相当于以前的spring配置文件
@Configuration
public class SpringConfig {

    //标注在方法上，向容器中添加组件，将方法的返回值添加到到容器中，将方法名作为组件id
    @Bean
    public Address address(){
        Address address = new Address();
        address.setCity("大桶大");
        address.setProvince("中国");

        return address;
    }
}
