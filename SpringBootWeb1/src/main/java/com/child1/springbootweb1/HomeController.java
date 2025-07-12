package com.child1.springbootweb1;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {



    @GetMapping("/")
    public String home() {
        System.out.println("HomeController: Handling request for home page");


        return "index";
    }

    @RequestMapping("/addNumbers")
    public String add(HttpServletRequest request) {
        String num1 = request.getParameter("num1");
        String num2 = request.getParameter("num2");
        System.out.println("HomeController: Handling request for addNumbers page with num1=" + num1 + " and num2=" + num2);

        return "addNumbers";
    }


}
