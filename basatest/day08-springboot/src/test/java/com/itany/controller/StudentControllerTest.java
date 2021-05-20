package com.itany.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Author：耿常安
 * Date：2021-03-08-8:58
 * Description：<描述>
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class StudentControllerTest {

    @Autowired
    private StudentController studentController;

    @Test
    public void test1(){
        String s = studentController.addStudent();
        System.out.println(s);
    }
}
