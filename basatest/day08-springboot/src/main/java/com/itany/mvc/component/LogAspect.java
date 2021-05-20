package com.itany.mvc.component;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Author：耿常安
 * Date：2021-03-07-21:34
 * Description：     AOP
 *
 * filter--->interceptor--->aop--->业务
 */

@Aspect
@Component
@Slf4j
public class LogAspect {

    @Pointcut("execution(public * com.itany.mvc.controller.*.*(..))")
    public void log(){

    }

    @Before("log()")
    public void before(){
        log.info("insepect  log before");
    }

    @After("log()")
    public void after(){
        log.info("insepect  log after");
    }
}
