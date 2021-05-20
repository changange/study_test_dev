package com.itany.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author：耿常安
 * Date：2021-03-03-17:09
 * Description：<描述>
 */

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "welcom to beijing";
    }

}
