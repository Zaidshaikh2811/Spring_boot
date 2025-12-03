package com.child1.springsecex.service;


import com.child1.springsecex.modal.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class StudentService {

    List<Student> students = new ArrayList<Student>();

    public StudentService() {

        this.students = List.of(
            new Student(1L, "John Doe", "john@gmial.com", "password"),
            new Student(2L, "Jane Smith", "jane@gmail.com", "password123")
        );
    }


    // Example method to get all students
     public List<Student> getAllStudents() {
            return students;
     }

    // Example method to add a student
     public Student addStudent(Student student) {

            students.add(student);
            return student;
     }
}
