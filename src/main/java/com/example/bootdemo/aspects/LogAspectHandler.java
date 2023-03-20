package com.example.bootdemo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class LogAspectHandler {
    private final static Logger logger = LoggerFactory.getLogger(LogAspectHandler.class);

    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void pointCut(){}
    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint){
        logger.info("=====entering doBefore()=====");
        Signature signature = joinPoint.getSignature();
        String declareType = signature.getDeclaringTypeName();
        String method = signature.getName();
        logger.info("calling:{}.{}", declareType, method);
        ////////
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();
        logger.info("requesting:{}|{}", url, ip);
    }
    @After("pointCut()")
    public void doAfter(JoinPoint joinPoint){
        logger.info("=====entering doAfter()=====");
        Signature signature = joinPoint.getSignature();
        String method = signature.getName();
        logger.info("leaving:{}", method);
    }
}
