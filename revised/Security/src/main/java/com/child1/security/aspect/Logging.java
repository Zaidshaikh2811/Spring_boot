package com.child1.security.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logging {

    @Before("execution(* com.child1.security.service.*.*(..))")
    public void logBefore() {
        System.out.println("A method is about to be executed.");
    }

    @Before("execution(public  com.child1.security.dto.StudentResponseDto com.child1.security.service.StudentService.addStudent(..))")
    public void logAddStudent() {
        System.out.println("addStudent method is about to be executed.");
    }
}
