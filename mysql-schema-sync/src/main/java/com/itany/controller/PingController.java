package com.itany.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author：耿常安
 * Date：2021-03-10-11:54
 * Description：<描述>
 */

@RestController
public class PingController {

    @RequestMapping("/ping")
    public String ping(){

        return "ping";
    }
}
