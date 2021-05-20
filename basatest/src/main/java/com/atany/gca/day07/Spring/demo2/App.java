package com.atany.gca.day07.Spring.demo2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author：耿常安
 * Date：2021-02-27-21:58
 * Description：<描述>
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new
                ClassPathXmlApplicationContext("day07/beans.xml");
        //通过对象匹配
        // HelloService helloService = applicationContext.getBean(HelloService.class);      //同一个接口有两个实现类就不能用对象去找了
        // String res = helloService.hi("杀掉");

        //通过ID匹配
        //当多个对象实现同一个接口时，要使用ID去解决
        HelloService helloService1 = (HelloService) applicationContext.getBean("hello");
        String res1 = helloService1.hi("杀掉");
        System.out.println("res=" + res1);
    }
}
