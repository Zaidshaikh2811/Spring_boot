package com.child1.app;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ValidationAspect {


     @Before("execution(* com.child1.JobController.getJobById(..)) && args(id)")
     public void validateArguments(Long id) throws Throwable {



        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid job ID: " + id);
        }



     }


}
