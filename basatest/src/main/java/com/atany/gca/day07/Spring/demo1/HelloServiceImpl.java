package com.atany.gca.day07.Spring.demo1;

/**
 * Author：耿常安
 * Date：2021-02-27-22:01
 * Description：<描述>
 */
public class HelloServiceImpl implements HelloService{
    private String name;
    private Aoo aoo;
    @Override
    public String hi(String name) {
        System.out.println("HelloServiceImpl.hi");
        return "Hi:" + name;
    }
}
