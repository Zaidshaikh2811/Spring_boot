package com.child1.security.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logging {

//    @Before("execution(* com.child1.security.service.*.*(..))")
//    public void logBefore() {
//        System.out.println("A method is about to be executed.");
//    }
//
//    @Before("execution(public  com.child1.security.dto.StudentResponseDto com.child1.security.service.StudentService.addStudent(..))")
//    public void logAddStudent() {
//        System.out.println("addStudent method is about to be executed.");
//    }
//
//
//    @After("execution(public void com.child1.security.service.StudentService.deleteStudent(*))")
//    public void logAfterDeleteStudent() {
//        System.out.println("deleteStudent method has been executed.");
//    }

    @Pointcut("execution(* com.child1.security.service.StudentService.*(..)) " )
    public void deleteStudentWithReasonPointcut() { }


    @Before("deleteStudentWithReasonPointcut()")
    public void logBeforeDeleteStudentWithReason(JoinPoint joinPoint) {
        System.out.println("deleteStudentWithReason method is about to be executed.");

        Object[] args = joinPoint.getArgs();
        for (Object obj : args) {
            System.out.println("Argument: " + obj);
        }


    }


    @Pointcut("execution(* com.child1.security.dto.*.*(..))")
    public void dtoMethodsPointcut() { }

    @Pointcut("execution(* com.child1.security.dto.*.get*(..))")
    public void dtoGettersPointcut() { }

    @Pointcut("execution(* com.child1.security.dto.*.set*(..))")
    public void dtoSettersPointcut() { }

    @Pointcut("dtoMethodsPointcut() &&  (dtoGettersPointcut() || dtoSettersPointcut() )")
    public void logBeforeDtoGetters() { }


    @Before("logBeforeDtoGetters()")
    public void logBeforeDtoMethods() {
        System.out.println("A DTO method  getter/setter is about to be executed.");
    }




}
