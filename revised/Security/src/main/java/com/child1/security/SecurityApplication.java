package com.child1.security;

import com.child1.security.model.Student;
import com.child1.security.repository.StudentRepo;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SecurityApplication {

    private StudentRepo studentRepo;

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}

    public SecurityApplication(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

//    @Bean
//    public CommandLineRunner init() {
//
//        return args -> {
//            Student student = new Student(
//                    "new",                          // ✅ name
//                    "user",                         // ✅ surname
//                    "new-user@gmail.com",           // ✅ email
//                    "password",    // ✅ encrypted password
//                    "USER"                          // ✅ role (NO ROLE_ prefix)
//            );
// Student Manager = new Student(
//                    "Manager",                          // ✅ name
//                    "Manager",                         // ✅ surname
//                    "Manager@gmail.com",           // ✅ email
//                    "password",    // ✅ encrypted password
//                    "MANAGER"                          // ✅ role (NO ROLE_ prefix)
//            );
// Student admin = new Student(
//                    "admin",                          // ✅ name
//                    "admin",                         // ✅ surname
//                    "admin@gmail.com",           // ✅ email
//                    "password",    // ✅ encrypted password
//                    "ADMIN"                          // ✅ role (NO ROLE_ prefix)
//            );
//
//            studentRepo.save(student);
//            studentRepo.save(Manager);
//            studentRepo.save(admin);
//
//            System.out.println("✅ Test user inserted into DB");
//        };
//    };

}
