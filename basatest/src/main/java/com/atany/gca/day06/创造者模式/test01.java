package com.atany.gca.day06.创造者模式;

/**
 * Author：耿常安
 * Date：2021-02-26-23:52
 * Description：<描述>
 */
public class test01 {
    public static void main(String[] args) {

        //正常的写法
        // User user = new User();
        // user.setAge(12);
        // user.setIp("192.168.1.12");
        // user.setName("换成那个");
        // System.out.println(user);

        //构造器
        User user1 = User.Builder.of().name("ca").age(12).ip("192.16.13.3").build();

        System.out.println(user1);

        // User2 user2=User2.builder().name("mos").ip("1.5.6.9").build();
        // System.out.println(user2);
    }
}
