package com.atany.gca.day07.Spring.demo7;

/**
 * Author：耿常安
 * Date：2021-02-28-15:44
 * Description：<描述>
 */

import com.atany.gca.day07.Spring.demo7.config.StudentConfig;
import com.atany.gca.day07.Spring.demo7.controller.StudentContorller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Spring-MVC
 *
 *
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext annotation = new AnnotationConfigApplicationContext(StudentConfig.class);
        StudentContorller sc = annotation.getBean(StudentContorller.class);
        sc.addStudent("傻逼");

    }
}
