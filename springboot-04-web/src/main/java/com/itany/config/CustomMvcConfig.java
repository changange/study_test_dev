package com.itany.config;

import com.itany.Interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Author：耿常安
 * Date：2021-03-05-21:50
 * Description：
 *
 *          扩展默认的springMVC功能
 *
 * 1、使用@Configuration标注为配置类
 * 2、实现webMVCConfigurer接口
 * 3、根据需要实现相应的方法
 * 注：这个接口中的方法都添加jdk8中的default方法修饰，不强制实现所有方法
 */

@Configuration
public class CustomMvcConfig implements WebMvcConfigurer {

    //添加ViewController
    @Override
    //访问showLogin  跳转到 login视图
    public void addViewControllers(ViewControllerRegistry registry) {
        //注册，通过那个URL跳转
        registry.addViewController("/showLogin").setViewName("login");
    }

    //添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截所有的  /**
        //不拦截    excludePathPatterns
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**").excludePathPatterns("/test2");
    }
}
