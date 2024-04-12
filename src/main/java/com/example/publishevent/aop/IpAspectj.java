package com.example.publishevent.aop;


import com.example.publishevent.utils.HttpContextUtils;
import com.example.publishevent.utils.IpContextUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
public class IpAspectj {

    @Pointcut("execution(* com.example.publishevent.controller..*.*(..))")
    public void pointCut() {
    };

    @Around("pointCut()")
    public void doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        String ipAddr = IpContextUtil.getIpAddr(request);
        System.out.println(ipAddr);
        joinPoint.proceed(joinPoint.getArgs());
    }
}
