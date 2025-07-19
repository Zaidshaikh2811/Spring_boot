package com.child1;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping
    public String sayHello(HttpServletRequest request) {
        return "Hello from Child1!" +
               " Request URI: " + request.getRequestURI() +
               " Request Method: " + request.getMethod()  +
                " Session ID: " + request.getSession().getId() ;
    }


    @GetMapping("/greet")
    public String greet(HttpServletRequest request) {
        return "Greetings from Child1!"+
                " Request URI: " + request.getRequestURI() +
                " Request Method: " + request.getMethod()  +
                " Session ID: " + request.getSession().getId() ;
    }


}
