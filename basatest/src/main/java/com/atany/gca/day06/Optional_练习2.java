package com.atany.gca.day06;

import java.util.Optional;

/**
 * Author：耿常安
 * Date：2021-02-25-22:02
 * Description：<描述>
 */

/**
 * 对一个返回值进行处理，不然返回null的时候还会自己处理，或者就报错了
 */
public class Optional_练习2 {
    public static void main(String[] args) {
        Optional<Integer> optianl = get("gca");
        //System.out.println("optional="+optianl.get());      //字符串为空时，会报错
        System.out.println(optianl.orElse(11));

    }

    public static Optional<Integer> get(String str){
        if (str.length()>4){
            return Optional.of(str.length());       //返回一个值
        }
        return Optional.empty();    //返回一个空
    }
}
