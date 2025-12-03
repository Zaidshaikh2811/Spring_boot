package com.child1.app;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;




@Component
@Aspect
public class LoggingAgent {


    private static final Logger logger =   LoggerFactory.getLogger(LoggingAgent.class );

    @Before("execution(* com.child1..*(..))")
    public void logBefore() {
        logger.info("A method is about to be executed");
    }

    @After("execution(* com.child1..*(..))")
    public void logAfter(JoinPoint joinPoint) {
        // Log the method name and arguments
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        logger.info("Method {} executed with arguments: {}", methodName, args);
        logger.info("A method has been executed");
    }






}
