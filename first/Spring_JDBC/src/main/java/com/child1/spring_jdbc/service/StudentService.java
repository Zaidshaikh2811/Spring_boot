package com.child1.spring_jdbc.service;

import com.child1.spring_jdbc.modal.Student;
import com.child1.spring_jdbc.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {


    private StudentRepo studentRepo;
    @Autowired
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }


    public void addStudent(Student student) {
        int rows = studentRepo.addStudent(student);
        if (rows > 0) {
            System.out.println("Student added successfully: " + student);
        } else {
            System.out.println("Failed to add student.");
        }
    }

    public void getStudents() {
        studentRepo.getStudents().forEach(System.out::println);
    }


}
