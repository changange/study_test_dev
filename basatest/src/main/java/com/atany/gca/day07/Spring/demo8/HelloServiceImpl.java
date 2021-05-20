package com.atany.gca.day07.Spring.demo8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Author：耿常安
 * Date：2021-02-27-22:01
 * Description：<描述>
 */

@Component("hello")
public class HelloServiceImpl implements HelloService {
    @Autowired
    private Doo doo;

    @Override
    public int hi() {
        doo.test();
        System.out.println("-----------HelloServiceImpl.hi");
        return 1;
    }

    @Override
    public void hei(String name) {
        System.out.println("-------------HelloServiceImpl.hei");
        System.out.println("name=" + name);
    }

    @Override
    public String test() {
        System.out.println("--------------HelloServiceImpl.test");
        //System.out.println(1/0);    //出现异常才通知
        return "test";
    }
}
