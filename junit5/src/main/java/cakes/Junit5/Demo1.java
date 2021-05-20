package cakes.Junit5;

import org.junit.jupiter.api.*;

/**
 * Author：耿常安
 * Date：2021-03-23-8:30
 * Description：<描述>
 */
public class Demo1 {

    //初始化
    @BeforeAll
    public static void init(){
        System.out.println("App.init");
    }

    //前置调用,下边的每一一个test方法都会去调用这个方法
    @BeforeEach
    public void preTest(){
        System.out.println("App.preTest");
    }

    //有test注解，都可以去运行
    @Test
    public void testNormal(){
        System.out.println("App.test1...............");
    }

    @Test
    public void test2(){
        System.out.println("App.test2................");
    }

    //后置调用
    @AfterEach
    public void postTest(){
        System.out.println("App.postTest");
    }

    //收尾工作
    @AfterAll
    public static void destory(){
        System.out.println("App.destory");
    }
}

