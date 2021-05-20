package com.itany.service;

import com.github.pagehelper.PageInfo;
import com.itany.pojo.User;

import java.util.List;

/**
 * Author：耿常安
 * Date：2021-03-06-11:10
 * Description：<描述>
 */
public interface UserService {
    public List<User> findAll();

    public User findById(int id);

    public void add(User user);

    public PageInfo<User> findByPage(int pageNum, int pageSize);
}
