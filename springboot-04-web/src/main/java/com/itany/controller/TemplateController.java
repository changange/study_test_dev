package com.itany.controller;

import com.itany.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * Author：耿常安
 * Date：2021-03-05-11:54
 * Description：<描述>
 */

@Controller
public class TemplateController {
    @RequestMapping("/test1")
    public String test1(Model model) {
        model.addAttribute("name", "alice");
        System.out.println("----------TemplateController.test1");
        return "success";   //自动添加前缀和后缀
    }

    @RequestMapping("/test2")
    public String test2(Model model) {
        model.addAttribute("hello", "<mark>你好</mark>");

        model.addAttribute("id", "mydiv");
        model.addAttribute("title", "this is title");
        model.addAttribute("age", 21);
        model.addAttribute("role", "teacher");

        model.addAttribute("names", Arrays.asList("gca", "mike", "tom"));


        User user = new User(1001, "tom", 23);
        model.addAttribute("user", user);
        return "result";
    }


    @RequestMapping("/modify")
    @ResponseBody       //直接响应给浏览器
    public String modify(@ModelAttribute("user") User user) {
        System.out.println("TemplelateNum：" + user);
        return "修改成功";
    }

    @RequestMapping("test3")
    public String test3(Model model, HttpSession session){
        model.addAttribute("user",new User(1002,"lack",33));

        ArrayList<User> users = new ArrayList<>();
        users.add(new User(1003,"gca",23));
        users.add(new User(1004,"cahngan",18));
        users.add(new User(1005,"anan",17));

        model.addAttribute("users",users);

        //session
        session.setAttribute("sex","male");
        session.setAttribute("hobby","game");

        model.addAttribute("birthday", new Date());
        return "list";
    }

    @RequestMapping("/findUser")
    @ResponseBody
    public String findUser(String username){
        System.out.println("TemplateController.findUser:" + username);
        return "success";
    }
}