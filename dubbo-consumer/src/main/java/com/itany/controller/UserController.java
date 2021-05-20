package com.itany.controller;

import com.itany.entity.User;
import com.itany.service.UserService;

/**
 * Author：耿常安
 * Date：2021-03-18-12:46
 * Description：<描述>
 */

// @Controller
public class UserController {

    //使用dubbo的 @Reference注入远程对象 注解版
    // @Reference
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void findUser(){
        System.out.println("------------------------");
        User byId = userService.findById(10001);
        System.out.println(byId);
    }
}
