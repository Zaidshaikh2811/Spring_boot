package com.child1.springbootweb1;

import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootWeb1Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWeb1Application.class, args);
        Tomcat tomcat = new Tomcat();
        try {
            tomcat.setPort(8080);
            tomcat.getConnector();
            tomcat.start();
            System.out.println("Tomcat started on port 8080");
            tomcat.getServer().await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
