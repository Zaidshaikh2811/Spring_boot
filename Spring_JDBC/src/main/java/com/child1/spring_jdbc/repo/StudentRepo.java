package com.child1.spring_jdbc.repo;

import com.child1.spring_jdbc.modal.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class StudentRepo {

    List<Student> students = new ArrayList<>();

    private final JdbcTemplate jdbcTemplate;

    public StudentRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    public int addStudent(Student student) {
            students.add(student);
          int rows=  jdbcTemplate.update("INSERT INTO students (id, name, email) VALUES (?, ?, ?)",
                    student.getId(), student.getName(), student.getEmail());

            return  rows;


    }

    public List<Student> getStudents() {
        return students;
    }


}
