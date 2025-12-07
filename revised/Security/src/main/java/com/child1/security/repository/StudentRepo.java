package com.child1.security.repository;

import com.child1.security.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
//@RepositoryRestResource()
public interface StudentRepo extends JpaRepository<Student,Integer> {

    Optional<Student> findByEmail(String email);
}
