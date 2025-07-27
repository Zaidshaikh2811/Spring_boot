package com.child1.springboot_first;

import com.child1.springboot_first.model.Apple;
import com.child1.springboot_first.service.AppleService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootFirstApplication {

    public static void main(String[] args) {


        ApplicationContext context = SpringApplication.run(SpringBootFirstApplication.class, args);

        Apple apple = context.getBean(Apple.class);
        apple.setModel("iPhone 14");
        Apple apple2 = context.getBean(Apple.class);
        System.out.println("Apple Model: " + apple2.getModel());


        AppleService appleService = context.getBean(AppleService.class);
        appleService.performAppleOperation();






    }

}
