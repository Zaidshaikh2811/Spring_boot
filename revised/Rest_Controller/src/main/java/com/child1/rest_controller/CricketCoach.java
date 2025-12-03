package com.child1.rest_controller;


import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    public String getDailyWorkout() {
        return "Yor Daily Workout";
    }

}
