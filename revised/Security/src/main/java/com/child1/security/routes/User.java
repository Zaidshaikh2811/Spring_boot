package com.child1.security.routes;


import com.child1.security.dto.StudentRequestDto;
import com.child1.security.dto.StudentResponseDto;
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


    @DeleteMapping("/students/{studentId}")
    public ResponseEntity<String> deleteString(@PathVariable int studentId){
        studentService.deleteStudent(studentId);
        return ResponseEntity.status(HttpStatus.OK).body("Student deleted successfully");
    }

    @DeleteMapping("/students/deleteWithReason/{studentId}" )
    public ResponseEntity<String> deleteStudentWithReason(@PathVariable int studentId, @RequestParam String reason){
        studentService.deleteStudentWithReason(studentId, reason);
        return ResponseEntity.status(HttpStatus.OK).body("Student deleted successfully for reason: " + reason);
    }
}
