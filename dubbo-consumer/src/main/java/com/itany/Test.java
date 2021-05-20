package com.itany;

import com.itany.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

/**
 * Author：耿常安
 * Date：2021-03-18-13:09
 * Description：<描述>
 */
public class Test {
    public static void main(String[] args) {
        //启动运行spring容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:consumer.xml");

        //获取usercontroller
        UserController bean = ac.getBean(UserController.class);
        bean.findUser();

        //阻塞线程不让结束
        new Scanner(System.in).next();
    }
}
