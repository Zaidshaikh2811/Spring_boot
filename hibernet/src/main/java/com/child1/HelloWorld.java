package com.child1;


import org.springframework.stereotype.Component;

@Component
public class HelloWorld {
    private String message;
    public HelloWorld() {
        System.out.println("Hello World CLass!");
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void getMessage() {
        System.out.println("Your Message: " + message);
    }
}
