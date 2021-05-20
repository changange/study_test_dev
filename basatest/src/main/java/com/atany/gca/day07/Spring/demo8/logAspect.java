package com.atany.gca.day07.Spring.demo8;

/**
 * Author：耿常安
 * Date：2021-02-28-17:43
 * Description：<描述>
 */

import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 切面
 */

@Aspect     //  切面
@Component
@Order(1)   //order越大越先执行完    after和before是个整体，整体执行完才算完
public class logAspect {

    //当有很多重复的这个过滤时，下边的方法可以直接写 point()，少些点代码
    @Pointcut("execution(public * com.atany.gca.day07.Spring.demo8.*.*(..))")   //切点
    public void point1(){}

    /**
     * execution(public * com.atany.gca.day07.*.*(..))
     *      上边的包搜索出来的方法才执行这个代码
     *      public：那些方法必须是public修饰的
     *      *：任意返回值
     *      com.atany.gca.day07.*：day07包下的任意类
     *      .*：任意方法
     *      (..)：方法的参数是任意的
     */
    @Before("point1()")          //前置通知
    public void before(){

        //织入
        System.out.println("logAspect.before1");
    }

    //操作之后的代码
    //h*：以h开头
    @After("execution(public * com.atany.gca.day07.Spring.demo8.*.*(..))")      //后置通知
    public void after(){
        System.out.println("logAspect.after1");
    }

    @AfterThrowing("point1()")      //异常通知
    public void afterThrow(){
        System.out.println("logAspect.afterThrow");
    }
    
    //@Around("point1()")      //环绕通知 （相当于一个集合）
    //public void round(ProceedingJoinPoint point){   //这个point会自动传入
    //    try {
    //        System.out.println("before");       //相当于前置
    //        point.proceed();    //就是执行原有的业务逻辑
    //        System.out.println("after");        //相当于后置
    //    } catch (Throwable throwable) {
    //        System.out.println("throw");        //相当于异常
    //    }finally {
    //        System.out.println("finally");      //最终
    //    }
    //}

    //return之后执行的通知
    //obj：用来接受方法的返回值
    @AfterReturning(pointcut="point1()" ,returning = "obj")     //最终通知  和after哪个是最终通知还后置通知，母鸡呀
    public void afterReturning(Object obj){
        System.out.println("obj=" + obj);
        System.out.println("logAspect.afterReturning");
    }
}
