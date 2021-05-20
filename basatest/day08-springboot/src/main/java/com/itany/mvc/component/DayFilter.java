package com.itany.mvc.component;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Author：耿常安
 * Date：2021-03-07-20:53
 * Description：     过滤器
 */
//@WebFilter(filterName = "dayFilter", urlPatterns = "/name")      //过滤器的第二种写法,只过滤/name,要注释第一种过滤器
@WebFilter(filterName = "dayFilter", urlPatterns = "/*")      //过滤器的第二种写法,只过滤/name,要注释第一种过滤器
@Slf4j
public class DayFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        response.setCharacterEncoding("utf-8");

        String name = request.getParameter("name");

        log.info("DayFilter url={}",request.getRequestURL());

        //继续调用其他过滤器，如果没有调用就走业务请求
        if(name!=null && name.equals("anan")){
            log.info("中国嘻嘻");
            PrintWriter writer = response.getWriter();

            writer.println("voer shijie");
            writer.flush();
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
