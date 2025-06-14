package com.example.proxies.classes;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Proxy;

@RestController
@RequestMapping("/api/man")
public class ManController {


    Man man =new Man("Mohan",30,"delhi","India");

    ClassLoader loader = ManController.class.getClassLoader();
    Class[] interfaces = new Class[]{Person.class};
    Person proxy = (Person) Proxy.newProxyInstance(loader, interfaces, new PersonInvocationHandler(man));


    @GetMapping
    public String getManIntro() {
        proxy.introduce(man.getName());
        proxy.sayAge(String.valueOf(man.getAge()));
        proxy.sayWhereFrom(man.getCity(), man.getCountry());
        return "Proxy methods invoked. Check console logs for output.";
    }



}
