package com.child1.rest_controller.service.imp;

import com.child1.rest_controller.DAO.imp.StudentDaoImp;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


@Service
public class Student {

    final private StudentDaoImp studentDaoImp;

    public Student(StudentDaoImp studentDaoImp) {
        this.studentDaoImp = studentDaoImp;
    }

    @Transactional
    public void createMultipleStudents() {

        // 1st operation
        com.child1.rest_controller.model.Student s1 = new com.child1.rest_controller.model.Student("null", "A", "null");
        studentDaoImp.saveStudent(s1);

        // 2nd operation
        com.child1.rest_controller.model.Student s2 = new com.child1.rest_controller.model.Student("null", "B", "21");
        studentDaoImp.saveStudent(s2);

        // 3rd operation — force error
        if(true) {
            throw new RuntimeException("Simulated failure for testing rollback");
        }

        // 4th operation (will never execute)
        com.child1.rest_controller.model.Student s3 = new com.child1.rest_controller.model.Student("null", "C", "22");
        studentDaoImp.saveStudent(s3);
    }
}
