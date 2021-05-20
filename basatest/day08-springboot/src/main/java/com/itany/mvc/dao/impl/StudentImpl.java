package com.itany.mvc.dao.impl;

import com.itany.mvc.dao.StudentDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

/**
 * Author：耿常安
 * Date：2021-03-06-14:53
 * Description：<描述>
 */
@Slf4j      //日志
@Repository     //交给springboot管理
public class StudentImpl implements StudentDao {

    @Override
    public int addStudent(){

        log.info("add  student.....");
        return 1;
    }
}
