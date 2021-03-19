package dev.wan.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Component
@Aspect // Spring AOP uses aspectj
public class LoggingAspect {
    private static int counter = 0;

    // advice method
    @Before("logPointCut()")
    public void logRequest(){
        System.out.println("Total HTTP calls: " + ++counter);
    }

    @After("logPointCut()")
    public void logAfterRequest(){
        System.out.println("");
    }


    // pointcut method
    @Pointcut("execution(* dev.wan.controllers.bookcontroller.*(..))")
    // regular expression selecting all
    private void logPointCut(){};
}
