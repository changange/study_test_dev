package com.atany.gca.day07.Spring.demo7.service.impl;

import com.atany.gca.day07.Spring.demo7.dao.StudentDao;
import com.atany.gca.day07.Spring.demo7.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author：耿常安
 * Date：2021-02-28-15:50
 * Description：<描述>
 */

@Service        //这注解也是被Component注释，告诉你这个类是服务层的类
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public void addStudent(String name) {
        studentDao.addStudent(name);
    }

    @Override
    public String findStudentById(int id) {
        return null;
    }
}
