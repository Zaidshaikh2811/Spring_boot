package com.child1.security.repository;

import com.child1.security.model.Department;
import com.child1.security.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DeptRepo extends JpaRepository<Department,Integer> {

    java.util.Optional<Department> findByName(String name);

}
