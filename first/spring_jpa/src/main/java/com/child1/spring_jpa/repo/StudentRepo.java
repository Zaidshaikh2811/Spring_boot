package com.child1.spring_jpa.repo;

import com.child1.spring_jpa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long> {

    Student findByName(String name);
    Student findByEmail(String email);
    Optional<Student> findById(Long id);
    void deleteById(Long id);
    void deleteByName(String name);
    void deleteByEmail(String email);
    boolean existsByName(String name);
    boolean existsByEmail(String email);
    boolean existsById(Long id);
    Student save(Student student);







}
