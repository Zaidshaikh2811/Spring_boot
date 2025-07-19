package com.child1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import jakarta.annotation.security.PermitAll;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;


@RestController
public class StuContoller {
    private final List<Student> students = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong();

    public StuContoller() {
        students.add(new Student("Alice", 20, "A", "123 Main St", "alice@example.com"));
        students.add(new Student("Bob", 22, "B", "456 Oak Ave", "bob@example.com"));
        students.add(new Student("Charlie", 21, "A", "789 Pine Rd", "charlie@example.com"));
    }


    @GetMapping("/csrf-token")

    public CsrfToken getToken(HttpServletRequest request) {

        return (CsrfToken) request.getAttribute("_csrf");


    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }

    @GetMapping("/students/{index}")
    public Student getStudent(@PathVariable int index) {
        if (index >= 0 && index < students.size()) {
            return students.get(index);
        }
        throw new IllegalArgumentException("Student not found");
    }

    @PutMapping("/students/{index}")
    public Student updateStudent(@PathVariable int index, @RequestBody Student student) {
        if (index >= 0 && index < students.size()) {
            students.set(index, student);
            return student;
        }
        throw new IllegalArgumentException("Student not found");
    }

    @DeleteMapping("/students/{index}")
    public String deleteStudent(@PathVariable int index) {
        if (index >= 0 && index < students.size()) {
            students.remove(index);
            return "Student deleted";
        }
        throw new IllegalArgumentException("Student not found");
    }
}
