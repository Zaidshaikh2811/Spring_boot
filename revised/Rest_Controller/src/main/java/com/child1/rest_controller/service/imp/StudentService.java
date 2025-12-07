package com.child1.rest_controller.service.imp;

import com.child1.rest_controller.DAO.imp.StudentDaoImp;
import com.child1.rest_controller.error.StudentNotFoundException;
import com.child1.rest_controller.repository.StudentRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import com.child1.rest_controller.model.Student;

@Service
public class StudentService {

    final private StudentDaoImp studentDaoImp;
    final private StudentRepo studentRepo;

    public StudentService(StudentDaoImp studentDaoImp , StudentRepo studentRepo) {
        this.studentDaoImp = studentDaoImp;
        this.studentRepo = studentRepo;
    }

    @Transactional
    public void createMultipleStudents() {

        // 1st operation
        Student s1 = new Student("test", "A", "test@gmail.com");
        studentRepo.save(s1);

        // 2nd operation
        Student s2 = new Student("test2", "B", "test2@gmail.com");
        studentRepo.save(s2);



        // 4th operation (will never execute)
        com.child1.rest_controller.model.Student s3 = new com.child1.rest_controller.model.Student("test3", "C", "test3@gmail.com");
        studentDaoImp.saveStudent(s3);
    }

    public Student  getStudentById(int id) {
        return studentRepo.findById(id).orElseThrow(()->new StudentNotFoundException("Student not found"));
    }

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public Student getStudentByEmail(String email) {
        return studentRepo.findByEmail(email);
    }

    public Student addStudent(Student student) {
        return studentRepo.save(student);
    }
}
