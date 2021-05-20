package com.atany.gca.day06;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Author：耿常安
 * Date：2021-02-23-23:10
 * Description：<描述>
 */

/**
 * 函数式接口编程      java8中提供了四种函数式编程
 * Function     转换型  T->R
 * Consumer     消费型
 * Predicate    断言型
 * Supplier     供给型
 */
public class 函数式编程 {
    public static void main(String[] args) {
        testPredicate();
    }

    //断言型
    public static void testPredicate(){
        Predicate<String> predicate = x->x.length()>3;
        boolean flag = predicate.test("xsas");
        System.out.println(flag);
    }
    //供给型
    public static void testSupplier(){
        Supplier<Integer> supplier = ()->(int)(Math.random()*10);
        int xx= supplier.get();
        System.out.println("xx=" + xx);
    }

    //消费型
    private static void testConsumer(){
        Consumer<String> consumer = x->{
            x=x+";";
            System.out.println(x);
        };
        consumer.accept("hi,pang");
    }

    //string装换成int
    private static void testFunction(){
        Function<String, Integer> function=(x)->x.length();
        int x = function.apply("asc");
        System.out.println("x=" + x);
    }
}
