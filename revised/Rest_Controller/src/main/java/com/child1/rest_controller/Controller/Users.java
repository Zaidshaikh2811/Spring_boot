package com.child1.rest_controller.Controller;


import com.child1.rest_controller.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Users {

    private final Coach coach;

    @Autowired
    public Users(Coach coach) {
        this.coach = coach;
    }

    @GetMapping("/")
    public String index() {
        return "Hello World updated";
    }

    @GetMapping("/random")
    public String random() {
        return "Random Number";
    }

    @GetMapping("/daily-workout")
    public String dailyWokrout() {
        return coach.getDailyWorkout();
    }


}
