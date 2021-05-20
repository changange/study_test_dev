package com.itany.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Author：耿常安
 * Date：2021-03-03-16:47
 * Description：@RestController  当前类的所有方法返回值都直接响应给浏览器
 */

// @Controller
@RestController     //相当@Controller+@ResponseBody
public class HelloController {

    @RequestMapping("/hello")
    // @ResponseBody    //如果有很多个方法都要直接响应给浏览器，就可以把这个注释，直接在类上写@RestController
    public String hello(){
        return "Hello SpringBoot";
    }

    @RequestMapping("/getMap")
    public Map<String,Object> getMap(){
        Map<String,Object> map = new HashMap<>();
        map.put("status",200);
        map.put("mseeage","成功了");
        return map;
    }
}
