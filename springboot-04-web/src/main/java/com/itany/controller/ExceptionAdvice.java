package com.itany.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Author：耿常安
 * Date：2021-03-05-22:47
 * Description：全局异常通知  全局异常第二种解决方式
 */

@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(ArithmeticException.class)
    public String arithmetic(Exception e){

        //这种方式无法拿到服务器的返回信息
        System.out.println("警报：程序异常，发短信："+e.getMessage());
        return "error/5xx";
    }

    @ExceptionHandler(Exception.class)
    public String exception(Exception e){
        System.out.println("其他警报：程序异常，发邮件："+e.getMessage());
        return "error/4xx";
    }
}
