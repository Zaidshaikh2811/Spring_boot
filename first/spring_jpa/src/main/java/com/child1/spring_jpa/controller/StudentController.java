package com.child1.spring_jpa.controller;


import com.child1.spring_jpa.model.Student;
import com.child1.spring_jpa.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepo studentRepo;

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentRepo.findById(id).orElseThrow();
        
    }
}
