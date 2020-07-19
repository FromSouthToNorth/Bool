package com.hy.blog.aspect;


import com.hy.blog.entity.Log;
import com.hy.blog.service.adminService.AdminLogServe;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;

@Aspect
@Component
public class LogAspect {

//    @Autowired
//    private AdminLogServe adminLogServe;
//
//    private Log log;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    // 配置切入点
    @Pointcut("execution(* com.hy.blog.api.*..*(..))")
    public void log() {  }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();
        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();
        String classMethod = joinPoint.getSignature().getDeclaringTypeName() + " . " + joinPoint.getSignature().getName();
        Object[] objects = joinPoint.getArgs();
        Log log = new Log(null, url, ip, classMethod, objects, new Date());
        logger.info("doBefore : " + log);

    }

    @After("log()")
    public void doAfter() {
//        adminLogServe.saveBog(log);
    }

    @AfterReturning(returning = "result", pointcut = "log()")
    public void doAfterReturn(Object result) {
        logger.info("Result: {}", result);
    }

}
