package com.child1.springsecex.controller;


import com.child1.springsecex.modal.Student;
import com.child1.springsecex.service.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class StuController {


    @Autowired
    private StudentService studentService;


     @GetMapping("/students")
     public List<Student> getAllStudents() {
         return studentService.getAllStudents();
     }

     @PostMapping("/students")
     public Student addStudent(@RequestBody Student student) {
         return studentService.addStudent(student);
     }


     @GetMapping("csrf-token")
        public String getCsrfToken(HttpServletRequest request) {

         return request.getAttribute("_csrf") != null ?
                request.getAttribute("_csrf").toString() :
                "CSRF token is not available.";
        }

}
