package com.atany.gca.day06;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Author：耿常安
 * Date：2021-02-25-21:49
 * Description：<描述>
 */
public class Optional_练习 {
    public static void main(String[] args) {
        //集合
        List<String> list = new ArrayList<>();
        list.add("cc");
        list.add("aa");
        list.add("asdf");
        list.add("aer");
        list.add("afdgtg");

        Optional<String> result = list.stream().filter(x->x.length()>3).findFirst();
        //System.out.println(result.get());   //为空的时候会报错

        //优雅的处理null问题
        //orElse()：如果有值  输出，没有值就输出 安安
        System.out.println(result.orElse("安安"));

        //orElseGet()：有值输出值，没有就按照自己写的方法生成一个值
        String s = result.orElseGet(() -> Math.random() + "");
        System.out.println("s=" + s);

    }
}
