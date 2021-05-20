package com.itany.mvc.config;

import com.itany.mvc.component.Interceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Author：耿常安
 * Date：2021-03-07-14:57
 * Description：<描述>
 */
@Configuration
@EnableScheduling       //启用定时器
//@ServletComponentScan(basePackages = "com.itany.mvc.component")
public class DayConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(new Interceptor());

        //添加哪些请求走拦截器
        interceptorRegistration.addPathPatterns("/**");  //  /*所有的都走

        //排除哪些路径
        //interceptorRegistration.excludePathPatterns();
    }

    //过滤器
    //@Bean
    //public FilterRegistrationBean<DayFilter> dayFilter(){
    //    FilterRegistrationBean<DayFilter> filter = new FilterRegistrationBean<>(new DayFilter());
    //    return filter;
    //}
}
