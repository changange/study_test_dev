package com.atany.gca.day06;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author：耿常安
 * Date：2021-02-26-22:54
 * Description：<描述>
 */
public class 线程池 {
    public static void main(String[] args) {
        test("gca");
        test("anan");
    }

    public static void test(String ss){
        ExecutorService executorService = Executors.newFixedThreadPool
                (Runtime.getRuntime().availableProcessors()*4);   //通过CPU核数的个数来创建几个线程
        executorService.submit(()-> System.out.println(ss));
    }
}
