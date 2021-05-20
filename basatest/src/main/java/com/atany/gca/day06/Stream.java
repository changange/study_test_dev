package com.atany.gca.day06;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Author：耿常安
 * Date：2021-02-24-22:17
 * Description：<描述>
 */
public class Stream {
    public static void main(String[] args) {
        //集合
        List<String> list = new ArrayList<>();
        list.add("cc");
        list.add("aa");
        list.add("asdf");
        list.add("aer");
        list.add("afdgtg");

        //List a开头 按字符串长度排序 输出一个字符串，用：连接
        List<String> ss = new ArrayList<>();
        for (String s:list){
           if(s.startsWith("a")){
               ss.add(s);
           }
        }
        //旧方式1：匿名内部类
        Collections.sort(ss, new Comparator<String>() {
           @Override
           public int compare(String o1, String o2) {
               return o2.length()-o1.length();
           }
        });
        System.out.println("是的=" + ss.toString());

        //旧方式2：lambad表达式
        Collections.sort(ss, (x,y)->(x.length()-y.length()));
        StringBuffer buffer = new StringBuffer();
        for(String s:ss){
           buffer.append(s).append(":");
        }
        System.out.println(buffer.toString());


        //====================================================================
        //串行
        String a = list.stream().filter(x -> x.startsWith("a"))
                //中间操作，就是可以连续点出很多歌相同的操作，如：.filter().filter
                //结束操作，就是只能点出一个。如：collect()
                .sorted((x, y) -> x.length() - y.length())
                .collect(Collectors.joining(";"));
        System.out.println("a11=" + a);

        //中间操作
        //map：转换型如：小写转换大写
        //filter：过滤型
        list.stream().map(x->x.toUpperCase())
               .filter(x->x.length()>3)
               //::：双冒号，方法引用：https://blog.csdn.net/qq_18948359/article/details/86361344
               //类名.方法名
               .forEach(System.out::println);

        //skip  跳过    如：跳过前两个
        //peek：用来调试用的，有时候可能写了一大堆代码，想看看中间的值符不符合预期，就可以用这个看看
        //limit:取前几个    如：前两个
        list.stream().skip(2).limit(2).forEach(x->System.out.println(x));
        list.stream().skip(2).peek(x->System.out.println("peek："+x)).map(x->x.toUpperCase()).forEach(x->System.out.println(x));

        //Distinct()    去重
        //list.stream().distinct().forEach(x->System.out.println(x));


    }
}
