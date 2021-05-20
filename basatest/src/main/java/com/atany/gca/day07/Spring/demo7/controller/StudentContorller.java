package com.atany.gca.day07.Spring.demo7.controller;

/**
 * Author：耿常安
 * Date：2021-02-28-15:51
 * Description：<描述>
 */

import com.atany.gca.day07.Spring.demo7.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 控制请求流向
 */

@Controller     //这注解也是被Component注释，告诉你这个类是调用层的类
public class StudentContorller {

    @Autowired      //1、自动注入进来
    private StudentService studentService;

    public void addStudent(String name ){
        studentService.addStudent(name);;
    }
}
