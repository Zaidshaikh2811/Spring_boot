package com.child1.rest_controller.service.imp;


import com.child1.rest_controller.service.Coach;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.context.properties.ConfigurationPropertiesBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
        public CricketCoach(){
            System.out.println("CricketCoach constructor");
        }


     public String getDailyWorkout() {
        return "Yor Daily Workout :-)";
    }

}
