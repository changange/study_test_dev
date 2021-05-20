package com.atany.gca.day07.Spring.demo8;

/**
 * Author：耿常安
 * Date：2021-02-28-19:58
 * Description：<描述>
 */

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 两个切面
 * @Order：越大越先执行完了
 */

//@Aspect
//@Component
//@Order(12)
public class logAspect2 {
    //当有很多重复的这个过滤时，下边的方法可以直接写 point()，少些点代码
    @Pointcut("execution(public * com.atany.gca.day07.Spring.demo8.*.*(..))")
    public void point(){}

    @Before("point()")
    public void before(){
        System.out.println("logAspect.before2");
    }

    @After("point()")
    public void after(){
        System.out.println("logAspect.after2");
    }
}
