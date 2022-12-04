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
    static private int numberProduct = 0;
    static private int numberCart = 0;

    @Pointcut("execution(* com.example.controller.ProductController.show*(..))")
    public void productApplication() {
    }

    @Pointcut("execution(* com.example.controller.CartController.show*(..))")
    public void cartApplication() {
    }

    @Before("productApplication()")
    public void beforeProduct() {
        System.out.println("Access number in Product is: " + ++numberProduct + " on " + LocalDateTime.now());
    }

    @Before("cartApplication()")
    public void beforeCart() {
        System.out.println("Access number in Cart is: " + ++numberCart + " on " + LocalDateTime.now());
    }

    @Pointcut("execution(* com.example.controller.ProductController.addToCart(..))")
    public void changeAddProduct() {
    }
    @Pointcut("execution(* com.example.controller.ProductController.subToCart(..))")
    public void changeSubProduct() {
    }
    @Pointcut("execution(* com.example.controller.CartController.pay(..))")
    public void changePayCart() {
    }

    @AfterReturning("changeAddProduct()")
    public void afterReturningAdd(JoinPoint joinPoint) {
        System.out.println("Complete the " + joinPoint.getSignature() + " method at " + LocalDateTime.now());
    }
    @AfterReturning("changeSubProduct()")
    public void afterReturningSub(JoinPoint joinPoint) {
        System.out.println("Complete the " + joinPoint.getSignature() + " method at " + LocalDateTime.now());
    }
    @AfterReturning("changePayCart()")
    public void afterReturningPay(JoinPoint joinPoint) {
        System.out.println("Complete the " + joinPoint.getSignature() + " method at " + LocalDateTime.now());
    }
}
