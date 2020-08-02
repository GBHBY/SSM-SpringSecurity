package com.gyb.controller;

import com.gyb.ssm.domain.SysLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @Author gb
 * @Date 2020/8/2 21:53
 * @Version 1.0
 * description:
 */
@Component
@Aspect
public class LogAop {

    @Autowired
    private HttpServletRequest request;

    /**
     * 访问的时间
     */
    private Date visitTime;
    /**
     * 访问的类
     */
    private Class className;
    /**
     * 访问的方法
     */
    private Method method;


    /**
     * create by: gb
     * description: 前置通知,主要是获取执行的开始时间，以及执行的类和方法
     * create time: 2020/8/2 21:54
     *
     * @param joinPoint
     * @return
     */
    @Before("execution(* com.gyb.controller.*.*(..))")
    public void doBefore(JoinPoint joinPoint) throws NoSuchMethodException {
        visitTime = new Date();
        /** 具体访问的类 */
        className = joinPoint.getTarget().getClass();
        /** 获取访问的方法的名称 */
        String methodName = joinPoint.getSignature().getName();
        /** 获取访问方法的参数 */
        Object[] args = joinPoint.getArgs();
        /**说明方法没有参数，也就是无参方法 */
        if (args == null || args.length == 0) {
            method = className.getMethod(methodName);
        } else {
            Class[] classArgs = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                classArgs[i] = args[i].getClass();
            }
            className.getMethod(methodName, classArgs);
        }


    }

    /**
     * create by: gb
     * description: 后置通知
     * create time: 2020/8/2 21:54
     *
     * @param joinPoint
     * @return
     */
    @After("execution(* com.gyb.controller.*.*(..))")
    public void doAfter(JoinPoint joinPoint) {
        /** 获取访问的url */
        String url = "";
        /** 当前时间减去访问时间就是浏览时长 */
        long time = System.currentTimeMillis() - visitTime.getTime();
        /** 获取访问的url */
        if (className != null && method != null && className != LogAop.class) {
            /** 获取类上的注解RequestMapping */
            RequestMapping classAnnotation = (RequestMapping) className.getAnnotation(RequestMapping.class);
            if (classAnnotation != null) {
                /** 方法上的RequestMapping值 */
                String[] classValue = classAnnotation.value();
                /** 获取当前方法上的注解值 */
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                if (methodAnnotation != null) {
                    String[] methodValue = methodAnnotation.value();
                    url = classValue[0] + methodValue[0];
                }
            }
        }
        /** 获取IP地址 */




    }

}
