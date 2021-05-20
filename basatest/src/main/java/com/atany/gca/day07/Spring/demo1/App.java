package com.atany.gca.day07.Spring.demo1;

/**
 * Author：耿常安
 * Date：2021-02-27-21:58
 * Description：<描述>
 */
public class App {
    public static void main(String[] args) throws Exception {
        //HelloService helloService = new HelloServiceImpl();
        //String res = helloService.hi("gengchangan");

        //工厂模式
        HelloService helloService = HelloFactory.getHeiiloService(HelloService.class);
        String res = helloService.hi("gengchangan shuai");
        System.out.println("res:"+res);
    }
}
