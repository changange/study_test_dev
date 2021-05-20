package com.itany.mapper;

import com.itany.pojo.User;

import java.util.List;

/**
 * Author：耿常安
 * Date：2021-03-06-10:55
 * Description：<描述>
 */
public interface UserMapper {
    public List<User> selectAll();

    public User selectById(int id);

    public void insert(User user);
}
