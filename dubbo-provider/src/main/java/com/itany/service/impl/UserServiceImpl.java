package com.itany.service.impl;

import com.itany.entity.User;
import com.itany.service.UserService;

/**
 * Author：耿常安
 * Date：2021-03-17-22:40
 * Description：<描述>
 */

// @Service    //注解版
// @com.alibaba.dubbo.config.annotation.Service  //dubbo注解，暴露接口
public class UserServiceImpl implements UserService {
    @Override
    public User findById(int id) {

        System.out.println("11111111111111111111111调用潮湿");
        // try {
        //     Thread.sleep(10000);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        System.out.println("UserServiceImpl.findById");
        User user = new User();
        user.setId(id);
        user.setUsernmae("tom");
        user.setPassword("123");

        return user;
    }
}
