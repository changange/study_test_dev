package com.itany;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

/**
 * Author：耿常安
 * Date：2021-03-18-13:05
 * Description：<描述>
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:provider.xml");

        //阻塞线程不让结束
        new Scanner(System.in).next();
    }
}
