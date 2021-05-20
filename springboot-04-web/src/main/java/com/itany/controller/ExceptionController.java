package com.itany.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author：耿常安
 * Date：2021-03-05-22:30
 * Description：  全局异常第一种解决方式  配合
 */

@Controller
@RequestMapping(("/exception"))
public class ExceptionController {
    //访问       http://localhost:8080/exception/test1?num=2
    @RequestMapping("test1")
    public String test1(int num){
        int i=5/num;
        return "success";
    }

    @RequestMapping("test2")
    public String test2(int num){
        String str = null;
        str.length();
        return "success";
    }
}
