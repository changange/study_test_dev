package com.itany.service.impl;

import com.itany.dao.UserDao;
import com.itany.entity.User;
import com.itany.service.UserService;
import com.itany.util.MybatisUtil;
import com.itany.vo.UserVo;

/**
 * Author：耿常安
 * Date：2021-02-01-13:17
 * Description：<描述>
 */
public class UserServiceIml implements UserService {

    private UserDao userDao;

    @Override
    public void regist(UserVo userVo) {
        MybatisUtil.getSession().getMapper(UserDao.class);

        User user = new User();
        user.setUsername(userVo.getUsername());
        user.setPassword(userVo.getPassword());
        user.setAge(userVo.getAge());
        //注册的时候可能还会有其他数据插入其他表，所以要用VO来做
        // Drving driver = new Driving();
        // driver.setDriving(userVo.getDriving());

        try {
            userDao.insert(user);
            MybatisUtil.getSession().commit();
        } catch (Exception e) {
            MybatisUtil.getSession().rollback();
            e.printStackTrace();
        }finally {
            MybatisUtil.getSession().close();
        }

    }
}
