package com.itany.controller;

import com.github.pagehelper.PageInfo;
import com.itany.pojo.User;
import com.itany.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author：耿常安
 * Date：2021-03-06-11:15
 * Description：<描述>
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public List<User> findAll(){
        List<User> users = userService.findAll();
        return users;
    }

    @RequestMapping("/findById")
    public User findById(int id){
        return userService.findById(id);
    }

    @RequestMapping("/add")
    public User add(User user){
        userService.add(user);
        return user;
    }

    @RequestMapping("/findByPage")
    public PageInfo findByPage(int pageNum){
        return userService.findByPage(pageNum,3);
    }
}
