package com.itany.controller;

import com.itany.mvc.entity.DBPro;
import com.itany.mvc.entity.ResultMsg;
import com.itany.mvc.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author：耿常安
 * Date：2021-03-07-13:29
 * Description：<描述>
 */

@RestController
public class ParamController {

    @Value("${sname}")
    private String name;

    @Autowired
    private Student student;

    @Autowired
    private DBPro dbPro;

    @RequestMapping("/name")
    public ResultMsg demo1() {
        ResultMsg resultMsg = ResultMsg.success(name);
        return resultMsg;
    }

    @RequestMapping("/student")
    public ResultMsg demo2() {
        ResultMsg resultMsg = ResultMsg.success(student);
        return resultMsg;
    }

    @RequestMapping("/db")
    public ResultMsg demo3() {
        ResultMsg resultMsg = ResultMsg.success(dbPro);
        return resultMsg;
    }
}
