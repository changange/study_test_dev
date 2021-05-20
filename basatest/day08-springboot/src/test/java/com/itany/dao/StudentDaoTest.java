package com.itany.dao;

import com.itany.mvc.dao.StudentDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Author：耿常安
 * Date：2021-03-08-9:11
 * Description：<描述>
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class StudentDaoTest {
    @Autowired
    private StudentDao studentDao;

    @Test
    public void findOne(){
        System.out.println("-------------------");
    }
}
