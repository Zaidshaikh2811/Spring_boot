package com.child1.security.aspect;


import com.child1.security.dto.StudentResponseDto;
import com.child1.security.model.Student;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

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


    @Order(1)
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


//    @AfterReturning(value = "execution(* com.child1.security.service.StudentService.getAllStudents(..))",returning = "result")
//    public void logAfterReturningGetAllStudents( List<StudentResponseDto> result) {
//        for(Student student : result) {
//            student.setName("TESTED_"+student.getName());
//        }

    @Order(2)
    @Around(value = "execution(* com.child1.security.service.StudentService.getAllStudents(..))")
    public Object logAfterReturningGetAllStudents(JoinPoint joinPoint) throws Throwable {
        System.out.println("getAllStudents method has been executed.");
        ProceedingJoinPoint pjp = (ProceedingJoinPoint) joinPoint;
        Object result = pjp.proceed();
        System.out.println(result   );
        List<StudentResponseDto> students = (List<StudentResponseDto>) result;
        for(StudentResponseDto student : students) {
            student.setName("TESTED_"+student.getName());
        }
        System.out.println("Modified Result: " + students);

        return students;

    }

}
