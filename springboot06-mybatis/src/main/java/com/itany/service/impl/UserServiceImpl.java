package com.itany.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itany.mapper.UserMapper;
import com.itany.pojo.User;
import com.itany.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Author：耿常安
 * Date：2021-03-06-11:12
 * Description：<描述>
 */
@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<User> findAll() {
        return userMapper.selectAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public User findById(int id) {
        return userMapper.selectById(id);
    }

    @Override
    public void add(User user) {
        userMapper.insert(user);
    }

    @Override
    public PageInfo<User> findByPage(int pageNum, int pageSize) {
        //使用PageHelper设置分页
        PageHelper.startPage(pageNum,pageSize);

        List<User> users = userMapper.selectAll();

        //分页信息
        PageInfo<User> userPageInfo = new PageInfo<>(users);

        return userPageInfo;
    }
}
