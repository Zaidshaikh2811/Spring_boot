package com.child1.security.service;


import com.child1.security.dto.StudentRequestDto;
import com.child1.security.dto.StudentResponseDto;
import com.child1.security.model.Department;
import com.child1.security.model.Student;
import com.child1.security.repository.DeptRepo;
import com.child1.security.repository.StudentRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    DeptRepo departmentRepo;
    StudentRepo studentRepo;
    public StudentService(DeptRepo departmentRepo, StudentRepo studentRepo) {
        this.departmentRepo = departmentRepo;
        this.studentRepo = studentRepo;
    }

    public List<StudentResponseDto> getAllStudents() {
        List<Student> students = studentRepo.findAll();

        return students.stream().map(student -> new StudentResponseDto(
                student.getId(),
                student.getName(),
                student.getSurname(),
                student.getEmail(),
                student.getRole(),
                student.getDepartment() != null
                        ? student.getDepartment().getName()
                        : null
        )).toList();
    }

    @Transactional
    public  StudentResponseDto addStudent(StudentRequestDto student) {
        if (studentRepo.findByEmail(student.getEmail()).isPresent()) {
            throw new IllegalStateException("email taken");
        }

        Department department =  departmentRepo.findByName(student.getDepartment())
                .orElseGet(()-> {
                    Department newDepartment = new Department();
                    newDepartment.setName(student.getDepartment());
                    return departmentRepo.save(newDepartment);
                });


        Student newStudent = new Student(
                student.getName(),
                student.getSurname(),
                student.getEmail(),
                student.getPassword(),
                student.getRole()
        );
        department.addStudent(newStudent);
        departmentRepo.save(department);
        return new StudentResponseDto(
                newStudent.getId(),
                newStudent.getName(),
                newStudent.getSurname(),
                newStudent.getEmail(),
                newStudent.getRole(),
                department.getName()
        );


        }



}
