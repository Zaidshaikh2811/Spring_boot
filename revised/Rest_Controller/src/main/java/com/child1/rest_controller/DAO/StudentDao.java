package com.child1.rest_controller.DAO;

import com.child1.rest_controller.model.Student;

import java.util.List;

public interface StudentDao {
      void saveStudent(Student student);

      void updateStudent(Student student);
      void deleteStudent(Student student);
      List<Student> findAllStudents();
      Student findStudentById(int id);
      Student findStudentByName(String name);
      Student findStudentByEmail(String email);
      Student findStudentByPhone(String phone);
}
