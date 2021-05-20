package com.atany.gca.day07.Spring.demo7.dao;

/**
 * Author：耿常安
 * Date：2021-02-28-15:45
 * Description：<描述>
 */
public interface StudentDao {
    void addStudent(String name);

    String findStdentById(int id);
}
