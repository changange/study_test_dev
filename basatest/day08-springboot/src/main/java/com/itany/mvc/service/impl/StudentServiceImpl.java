package com.itany.mvc.service.impl;

import com.itany.mvc.dao.StudentDao;
import com.itany.mvc.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author：耿常安
 * Date：2021-03-06-15:37
 * Description：<描述>
 */

/*
    业务相关的参数检验放在service层
 */
@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public boolean addStudent() {
        log.info("service...");
        studentDao.addStudent();
        return false;
    }
}

