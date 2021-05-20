package com.atany.gca.day07.Spring.demo8;

/**
 * Author：耿常安
 * Date：2021-02-28-11:12
 * Description：<描述>
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * 通过注解的方式来实现
 */
// @Configuration       //好像写不写这个都无所谓
@Component
@ComponentScan
@EnableAspectJAutoProxy     //启用切面，需要加在 @Configuration注解上的类
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        //一定要是接口，从接口找实现类
        HelloService helloService = context.getBean(HelloService.class);
        helloService.hi();

        // helloService.test();

        //helloService.hei("中国");
    }
}