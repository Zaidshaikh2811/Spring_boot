package com.child1.rest_controller.Controller;


import com.child1.rest_controller.service.Coach;
import com.child1.rest_controller.service.imp.CricketCoach;
import com.child1.rest_controller.service.imp.Football;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
public class Users {

    private final Coach coach;
    private final Coach football;



    @Autowired
    public Users(Coach coach , Coach football) {
        this.coach = coach;
        this.football=football;
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

    @PostMapping("/pathMapping/{id}")
    public String pathMapping(@PathVariable String id) {
        return "the @PathVariable id is " + id;
    }

    @GetMapping("/RequestMapping")
    public String requestMapping(@RequestParam String id){
        return "The Request Mapping id is "+ id ;
    }

    @GetMapping("/compare")
    public String compare(){
        return "Compare Coach and football bean: " + football.equals(coach) ;
    }


}
