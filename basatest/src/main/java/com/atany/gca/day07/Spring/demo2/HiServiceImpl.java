package com.atany.gca.day07.Spring.demo2;

/**
 * Author：耿常安
 * Date：2021-02-28-10:48
 * Description：<描述>
 */
public class HiServiceImpl implements HelloService{
    @Override
    public String hi(String name) {
        System.out.println("HiServiceImpl.hi");
        return "吃饭了吗：" +name;

    }
}
