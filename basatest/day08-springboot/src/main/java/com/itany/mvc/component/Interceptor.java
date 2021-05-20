package com.itany.mvc.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Author：耿常安
 * Date：2021-03-07-14:45
 * Description： 拦截器
 *
 * 拦截请求，登录验证
 */
@Slf4j
public class Interceptor implements HandlerInterceptor {
   //前置处理器
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("Interceptor 前置处理器");
        String token = response.getHeader("token");
        log.info("tocken={}",token);
        if(token==null) {
            //return false;
            return true;
        }
        if(token.equals("1234")) {
            return true;
        }
        return false;
    }

    //后置处理器
    //如：数据加密
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("Interceptor 后置处理器");

    }

    //处理完成
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
