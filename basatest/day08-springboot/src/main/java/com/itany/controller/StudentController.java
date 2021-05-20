package com.itany.controller;

import com.itany.mvc.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author：耿常安
 * Date：2021-03-06-15:35
 * Description：<描述>
 */

/**
 * @Controller:拦截器、过滤器、统一参数校验(名字不为空)
 *              统计的工作 PV、UV
 *              service的异常处理
 */
@RestController
@Slf4j
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/add")
    public String addStudent(){
        log.info("controller");
        boolean b = studentService.addStudent();
        return b?"成功":"失败";
    }
}
