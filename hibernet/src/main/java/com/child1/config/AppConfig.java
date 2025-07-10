package com.child1.config;


import com.child1.HelloWorld;
import com.child1.Laptop;
import com.child1.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

     @Bean(name = "com.child1.Laptop")
        public Student  getStudent(){      /* */
            Student student = new Student();
            student.setName("Nilesh Patil");
            student.setEmail("Nilesh@Patil");
            student.setHasLaptop(
                    new Laptop("SN12345", "Dell", "XPS 15", 16, 512)
            );
            return student;
        }

    @Bean(name = "com.child1.Student")
    public Student student() {
        Student student = new Student();
        student.setName("John Doe");
        student.setEmail("john@23");
        student.setHasLaptop(
                new Laptop("SN12345", "Dell", "XPS 15", 16, 512)
        );
        return student;
    }



    @Bean(name = "com.child1.HelloWorld")
    public HelloWorld helloWorld() {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setMessage("Hello AppConfig, Spring with Hibernate!");
        return helloWorld;
    }

}
