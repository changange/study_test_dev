package com.itany.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.itany.entity.User;
import com.itany.service.UserService;
import org.springframework.stereotype.Component;

/**
 * Author：耿常安
 * Date：2021-03-19-8:48
 * Description：<描述>
 */

@Component
@Service(timeout = 3000)        //超时时间
public class UserServiceImpl implements UserService {
    @Override
    public User findById(int id) {
        User user = new User();
        user.setId(1111);
        user.setUsernmae("tttt");
        user.setPassword("76756");
        return user;
    }
}
