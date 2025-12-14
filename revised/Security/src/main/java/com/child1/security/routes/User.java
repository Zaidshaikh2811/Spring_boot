package com.child1.security.routes;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class User {



    @RequestMapping("/user")
    public String user(){
        return "Hello User";
    }
}
