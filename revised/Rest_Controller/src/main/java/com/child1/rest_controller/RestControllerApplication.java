package com.child1.rest_controller;

import com.child1.rest_controller.DAO.StudentDao;
import com.child1.rest_controller.DAO.imp.StudentDaoImp;
import com.child1.rest_controller.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class RestControllerApplication {
    private final StudentDaoImp studentDaoImp;


	public static void main(String[] args) {
		SpringApplication.run(RestControllerApplication.class, args);
	}


    @Autowired
    public  RestControllerApplication(StudentDaoImp studentDaoImp ) {
        this.studentDaoImp = studentDaoImp;

    }

    @Bean
    public CommandLineRunner init( ) {
        return lambda ->{
            System.out.println("hello world");
//            studentDaoImp.saveStudent(new Student("apple","cook","appleCook3@apple.com"));
//                student.createMultipleStudents();
            List<Student> stu=studentDaoImp.findAllStudents();
                for (Student s: stu) {
                    System.out.println(s);
                }

        };
    }


}
