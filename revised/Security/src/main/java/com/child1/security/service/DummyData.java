package com.child1.security.service;

import com.child1.security.model.Department;
import com.child1.security.model.Student;
import com.child1.security.repository.StudentRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class DummyData  {
        private StudentRepo studentRepo;

        public DummyData(StudentRepo studentRepo) {
            this.studentRepo = studentRepo;
        }




//    @Bean
//    public void AddData() {
//            Student student = new Student(
//                    "new",
//                    "user",
//                    "new-user@gmail.com",
//                    "password",
//                    "USER"
//            );
//            Student Manager = new Student(
//                    "Manager",
//                    "Manager",
//                    "Manager@gmail.com",
//                    "password",
//                    "MANAGER"
//            );
//            Student admin = new Student(
//                    "admin",
//                    "admin",
//                    "admin@gmail.com",
//                    "password",
//                    "ADMIN"
//            );
//
//            studentRepo.save(student);
//            studentRepo.save(Manager);
//            studentRepo.save(admin);
//
//    };

//    @Override
//    public void run(String... args) {
//            Student student = new Student();
//
//
//            student.setName("John");
//            student.setSurname("Doe");
//            student.setEmail("doe@gmail.com");
//            student.setPassword("password");
//            student.setRole("USER");
//
//            Department department = new Department();
//            department.setName("CSE");
//            department.setStudentId(student);
//            student.setDepartment(department);
//
//            studentRepo.save(student);
//        System.out.println("Dummy Data Inserted");
//        }
}

