package com.atany.gca.day07.Spring.demo8;

import org.springframework.stereotype.Component;

/**
 * Author：耿常安
 * Date：2021-02-28-19:16
 * Description：<描述>
 */

@Component
public class Doo {
    //protected void test(){    //过滤的规则是public所以 protected不会打印after和befer
    public void test(){     //public修饰符，可以打印before和after
        System.out.println("-------------Doo.test");
    }
}
