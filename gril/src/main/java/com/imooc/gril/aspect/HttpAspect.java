package com.imooc.gril.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {

    private final static Logger  logger = LoggerFactory.getLogger(HttpAspect.class);
/*
    @Before("execution(public * com.imooc.gril.controller.GirlController.girlList(..))")
    public void log() {
        System.out.println("11111111111");
    }

    @After("execution(public * com.imooc.gril.controller.GirlController.girlList(..))")
    public void doAfter () {
        System.out.println("----------------");
    }*/

    /*
    上面那种又在写重复的代码
     */

    @Pointcut("execution(public * com.imooc.gril.controller.GirlController.girlList(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url:全路径，
        logger.info("url={}",request.getRequestURL());
        //method
        logger.info("method={}",request.getMethod());
        //ip
        logger.info("ip={}",request.getRemoteAddr());
        //类方法
        logger.info("class_method = {}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //参数
        logger.info("args={}",joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter() {
       logger.info("222222222");
    }

    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturning(Object object) {
        logger.info("response={}",object);
    }
}
