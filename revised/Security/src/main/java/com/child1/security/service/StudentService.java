package com.child1.security.service;


import com.child1.security.dto.StudentRequestDto;
import com.child1.security.dto.StudentResponseDto;
import com.child1.security.model.Department;
import com.child1.security.model.Student;
import com.child1.security.repository.StudentRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    StudentRepo studentRepo;
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public List<Student> getStudentRepo() {
        return studentRepo.findAll();
    }

    @Transactional
    public  StudentResponseDto addStudent(StudentRequestDto student){
        if(studentRepo.findByEmail(student.getEmail()).isPresent()){
            throw new IllegalStateException("email taken");
        }


        Student newStudent = new Student(
                student.getName(),
                student.getSurname(),
                student.getEmail(),
                student.getPassword(),
                student.getRole()
        );

        Department department = new Department();
        department.setName(student.getDepartment());
        department.setStudentId(newStudent);
        newStudent.setDepartment(department);

        Student saved = studentRepo.save(newStudent);

return new StudentResponseDto(
        saved.getId(),
        saved.getName(),
        saved.getSurname(),
        saved.getEmail(),
        saved.getRole()
);
    }


}
