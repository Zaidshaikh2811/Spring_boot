package com.child1.repo;

import com.child1.modal.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Integer> {

 Student findByUsername(String username);
}
