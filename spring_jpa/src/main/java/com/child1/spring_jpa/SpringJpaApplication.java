package com.child1.spring_jpa;

import com.child1.spring_jpa.model.Student;
import com.child1.spring_jpa.repo.StudentRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJpaApplication {

    public static void main(String[] args) {

        System.out.println("Spring JPA Application Started Successfully!");
        StudentRepo repo = SpringApplication.run(SpringJpaApplication.class, args).getBean(StudentRepo.class);


        repo.deleteAll();
        Student student = new Student();
        student.setName("John Doe");
        student.setEmail("john@gmail.com");
        repo.save(student);
        System.out.println("Saved Student: " + student);
        System.out.println("Find by ID: " + repo.findById(1L).orElse(null));



        repo.findAll().forEach(System.out::println);
        System.out.println("Find by name: " + repo.findByName("John Doe"));



    }

}
