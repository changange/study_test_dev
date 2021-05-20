package com.atany.gca.day07.Spring.demo3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author：耿常安
 * Date：2021-02-28-11:12
 * Description：<描述>
 */

/**
 * 通过注解的方式来实现
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new
                ClassPathXmlApplicationContext("day07/demo3-beans.xml");
        //通过对象匹配
        HelloService helloService = applicationContext.getBean(HelloService.class);
        // HelloService helloService1 = (HelloService) applicationContext.getBean("gca");
        HelloService helloService2 = (HelloService) applicationContext.getBean("helloServiceImpl");
        String res = helloService.hi("杀掉");
        System.out.println(res);
    }
}
