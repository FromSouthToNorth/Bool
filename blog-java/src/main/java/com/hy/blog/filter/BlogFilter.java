package com.hy.blog.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@WebFilter(filterName = "CorsFilter")
@Configuration
public class BlogFilter implements Filter {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        // 设置允许访问本服务API的 多个域名
        String[] allowDomains = {
                "http://localhost:8080",
                "http://127.0.0.1:8080",
                "http://localhost:8081",
                "http://127.0.0.1:8081"
        };
        Set allowOrigins = new HashSet(Arrays.asList(allowDomains));
        // 获取当前发起请求的域名
        String originHeads = request.getHeader("Origin");
        System.out.println(originHeads);
        logger.info("originHeads : {}", originHeads);
        if (allowOrigins.contains(originHeads)) {
            response.setHeader("Access-Control-Allow-Origin", originHeads);
            response.setHeader("Access-Control-Allow-Credentials", "true");
            response.setHeader("Access-Control-Allow-Methods", "POST, GET, PATCH, DELETE, PUT");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, token");
        }
        System.out.println(request.getHeader("token"));
        // 判断请求头参数
        try {
            if (request.getHeader("token").equals("MyToken"))
                filterChain.doFilter(request, response);
        } catch (Exception e) {}
    }

}
