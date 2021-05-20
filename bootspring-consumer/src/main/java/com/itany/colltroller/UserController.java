package com.itany.colltroller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itany.entity.User;
import com.itany.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author：耿常安
 * Date：2021-03-19-8:57
 * Description：<描述>
 */

@Component
@RequestMapping("/user")
public class UserController {

    //修改负载均衡策略
    @Reference(loadbalance = "roundrobin")  //dubbo注解
    private UserService userService;

    @RequestMapping("/findUser")
    public String findUser(int id, Model  model){
        System.out.println("----------------------"+userService);
        User user = userService.findById(id);
        model.addAttribute("user",user);

        return "success";
    }
}
