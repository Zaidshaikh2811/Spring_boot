package com.child1.rest_controller.repository;

import com.child1.rest_controller.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


@Repository
//@RepositoryRestResource()
public interface StudentRepo extends JpaRepository<Student,Integer> {

    Student findByEmail(String email);
}
