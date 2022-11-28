package com.nwpn.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author GengXuelong
 * @version 1.0
 * @Mail 3349495429@qq.com
 * @Date 2022/11/28
 * @ClassName MyAop
 * @Description:
 */
@Aspect
@Component
public class MyAop {
    @Pointcut("execution(* com.nwpn.controller.*.*(..))")
    public void where(){}

    @Before("where()")
    public void before(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        String methodName = signature.getName();//方法名：hello
        String className = signature.getDeclaringTypeName();//类名
        System.out.println("======>进入"+className+"类的"+methodName+"方法");

    }
    @After("where()")
    public void after(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        String methodName = signature.getName();//方法名：hello
        String className = signature.getDeclaringTypeName();//类名
        System.out.println("======>出"+className+"类的"+methodName+"方法");
    }
}
