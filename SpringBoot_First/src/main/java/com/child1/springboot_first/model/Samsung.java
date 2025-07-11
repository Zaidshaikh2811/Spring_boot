package com.child1.springboot_first.model;


import org.springframework.stereotype.Component;

@Component
public class Samsung implements  Mobile {

    @Override
    public void call() {
        System.out.println("Calling from Samsung");
    }

    public void playGame() {
        System.out.println("Playing game on Samsung");
    }
}
