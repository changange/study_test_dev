package com.atany.gca.day06;

import java.util.ArrayList;
import java.util.List;

/**
 * Author：耿常安
 * Date：2021-02-26-8:22
 * Description：<描述>
 */
public class 方法引用 {
    public static void main(String[] args) {
        //集合
        List<String> list = new ArrayList<>();
        list.add("cc");
        list.add("aa");
        list.add("asdf");
        list.add("aer");
        list.add("afdgtg");

        list.stream().map(x -> x.toUpperCase())
                .forEach(x -> System.out.println(x));

        list.stream().map(String::toUpperCase)      //实例方法
                .forEach(System.out::println);

        //(x,y)->x.compareTo(y) 一个方法有很多参数，第一个参数作为调用者，之后的其他参数就是被调用者（默认的）
        list.stream().sorted(String::compareTo).forEach(System.out::println);

        list.stream().map(Person::new).forEach(System.out::println);

        Boo boo2 = int[]::new;

    }


}

//类名，静态方法
interface Coo{
    List<Integer> b(int x);
}

@FunctionalInterface
interface Boo{
    int[] b(int x);
}

class Person{
    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
