package com.child1.security.routes;


import com.child1.security.dto.StudentRequestDto;
import com.child1.security.dto.StudentResponseDto;
import com.child1.security.model.Student;
import com.child1.security.repository.StudentRepo;
import com.child1.security.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class User {

    StudentService studentService;
    public User(StudentService studentService) {
        this.studentService = studentService;
    }


    @RequestMapping("/user")
    public String user(){
        return "Hello User";
    }

    @PostMapping("/students")
    public ResponseEntity<StudentResponseDto> addStudentController(@Valid @RequestBody StudentRequestDto student){
        StudentResponseDto responseDto = studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }


    @GetMapping("/students")
    public ResponseEntity<List<StudentResponseDto>> getStudents() {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudents());
    }
}
