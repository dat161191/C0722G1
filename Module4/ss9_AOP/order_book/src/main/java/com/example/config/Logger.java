package com.example.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class Logger {
    static private int number = 0;

    @Pointcut("execution(* com.example.controller.OderBookController.listBook(..))")
    public void accessApplication() {
    }

    @Before("accessApplication()")
    public void beforeAccess() {
        System.out.println("Access number is: " + ++number + " on " + LocalDateTime.now());
    }

    @Pointcut("execution(* com.example.controller.OderBookController.save*(..))")
    public void changeData() {
    }

    @AfterReturning("changeData()")
    public void afterReturningSave(JoinPoint joinPoint) {
        System.out.println("Complete the " + joinPoint.getSignature() + " method at " + LocalDateTime.now());
    }
}
