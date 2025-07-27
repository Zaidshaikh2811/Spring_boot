package com.child1.spring_jdbc;

import com.child1.spring_jdbc.modal.Student;
import com.child1.spring_jdbc.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJdbcApplication {

    public static void main(String[] args) {

       ApplicationContext context= SpringApplication.run(SpringJdbcApplication.class, args);

        StudentService student =  context.getBean(StudentService.class);
        Student student1 = new Student(1, "John Doe", "john@gmail.com");
        student.addStudent(student1);
        Student student2 = new Student(2, "Jane Smith", "jane@gmail.com");
        student.addStudent(student2);
        Student student3 = new Student(3, "Alice Johnson", "alice@gmail.com");
        student.addStudent(student3);
        System.out.println("All Students:");
        student.getStudents();


    }

}
