package com.child1.rest_controller.service.imp;

import com.child1.rest_controller.service.Coach;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary

public class Football implements Coach {

    public Football(){
        System.out.println("Football constructor");
    }


    @PostConstruct
    public void init(){
        System.out.println("Football init");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Football destroy");
    }

    public String getDailyWorkout() {
        return "getDailyWorkout from Football";
    }
}
