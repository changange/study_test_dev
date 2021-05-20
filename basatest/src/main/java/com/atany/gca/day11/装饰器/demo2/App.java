package com.atany.gca.day11.装饰器.demo2;

/**
 * Author：耿常安
 * Date：2021-03-15-22:10
 * Description：<描述>
 */
public class App {
    public static void main(String[] args) {
        String str = "qwew-eee-randomId(3)-3455-randomStr(5)-rgrt2345";
        String s = DecoratorManager.of().replace(str);
        System.out.println("s=" + s);
    }
}
