package com.child1.app;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class PerformanceAspect {

    // This class can be used to implement performance monitoring aspects
    // For example, you can use @Around advice to measure method execution time
    // and log performance metrics.

    private static final Logger logger =   LoggerFactory.getLogger(LoggingAgent.class );

    // Example method to log performance metrics
     @Around("execution(* com.child1..*(..))")
     public Object logPerformance(ProceedingJoinPoint joinPoint) throws Throwable {
         long startTime = System.currentTimeMillis();
         Object result = joinPoint.proceed();
         long endTime = System.currentTimeMillis();
         logger.info("Method {} executed in {} ms", joinPoint.getSignature().getName(), (endTime - startTime));
         return result;
     }
}
