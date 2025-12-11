package com.child1.security.service;

import com.child1.security.model.Student;
import com.child1.security.repository.StudentRepo;
import org.springframework.context.annotation.Bean;

public class DummyData {
        private StudentRepo studentRepo;

        public DummyData(StudentRepo studentRepo) {
            this.studentRepo = studentRepo;
        }

//    @Bean
    public void AddData() {


            Student student = new Student(
                    "new",
                    "user",
                    "new-user@gmail.com",
                    "password",
                    "USER"
            );
            Student Manager = new Student(
                    "Manager",
                    "Manager",
                    "Manager@gmail.com",
                    "password",
                    "MANAGER"
            );
            Student admin = new Student(
                    "admin",
                    "admin",
                    "admin@gmail.com",
                    "password",
                    "ADMIN"
            );

            studentRepo.save(student);
            studentRepo.save(Manager);
            studentRepo.save(admin);

    };

}

