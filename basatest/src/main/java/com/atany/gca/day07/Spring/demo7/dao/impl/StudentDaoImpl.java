package com.atany.gca.day07.Spring.demo7.dao.impl;

import com.atany.gca.day07.Spring.demo7.dao.StudentDao;
import org.springframework.stereotype.Repository;

/**
 * Author：耿常安
 * Date：2021-02-28-15:47
 * Description：<描述>
 */

@Repository
public class StudentDaoImpl implements StudentDao {

    @Override
    public void addStudent(String name) {
        System.out.println("add student " +name+" success....");
        System.out.println("StudentDaoImpl.addStudent");
    }

    @Override
    public String findStdentById(int id) {
        System.out.println("StudentDaoImpl.findStdentById");
        return "习近平";
    }
}
