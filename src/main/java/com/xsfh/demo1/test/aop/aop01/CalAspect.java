package com.xsfh.demo1.test.aop.aop01;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 切面类
 */
@Aspect
@Component
@Slf4j
public class CalAspect {
    //前置通知
    @Before("execution(public int com.xsfh.demo1.test.aop.aop01.CalculatorImpl.*(..))")
    public void beforeMethod(JoinPoint joinPoint){
        log.info("[{}]的参数为：[{}]",joinPoint.getSignature().getName(),Arrays.toString(joinPoint.getArgs()));
    }
    //成功通知
    @AfterReturning(value = "execution(public int com.xsfh.demo1.test.aop.aop01.CalculatorImpl.*(..))",returning = "result")
    public void afterReturning(JoinPoint joinPoint,Object result){
        log.info("[{}]的结果为：[{}]",joinPoint.getSignature().getName(), result);
    }
    //定义切点
    @Pointcut("execution(* com.xsfh.demo1.test.aop.aop01.controller.AopController.testAOP02())(..))")
    public void point(){

    }
    //环绕通知
    @Around("point()")
    public Object calculateTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        //调用方法
        proceedingJoinPoint.proceed();
        long endTime = System.currentTimeMillis();
        log.info("[{}]方法执行的时长为：[{}]",proceedingJoinPoint.getSignature().getName(),endTime-startTime);
        return proceedingJoinPoint;
    }
}
