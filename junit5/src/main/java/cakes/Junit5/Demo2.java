package cakes.Junit5;

import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

/**
 * Author：耿常安
 * Date：2021-03-23-8:47
 * Description：<描述>
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)   //方法执行的顺序，OrderAnnotation：按照order的大小执行。默认是基于名字的排序
public class Demo2 {

    //@Test     //@RepeatedTest(3)重复调用3次，有这个就不用写test了
    @RepeatedTest(3)
    public void testCase1(){
        System.out.println("Demo1.testCase=========");
    }

    @Test
    public void testCase2(){
        System.out.println("Demo2.testCase=========");
    }


    @Test
    @Disabled   //不执行这个test方法
    public void testCase3(){
        System.out.println("Demo3.testCase=========");
    }

    @Test
    @Order(1)
    public void testCase4(){
        System.out.println("Demo4.testCase=========");
    }

    @Test
    public void testCase5(){
        System.out.println("Demo5.testCase=========");
    }

    @Test
    @Timeout(value=3,unit = TimeUnit.SECONDS)   //超时时间，unit：单位的意思，默认是秒  超时报错
    public void testCase6() throws InterruptedException {
        Thread.sleep(5*1000);
        System.out.println("Demo2.testCase6");

    }
}
