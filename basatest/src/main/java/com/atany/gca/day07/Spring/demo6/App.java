package com.atany.gca.day07.Spring.demo6;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Author：耿常安
 * Date：2021-02-28-13:08
 * Description：<描述>
 */
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotation = new
                AnnotationConfigApplicationContext(HelloConfiguration.class);   //加载配置类
        //通过对象匹配
        HelloService helloService = annotation.getBean(HelloService.class);

        String res = helloService.hi("杀掉");
        System.out.println(res);
    }
}
