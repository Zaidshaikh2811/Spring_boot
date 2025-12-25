package com.child1.hospital.repository;

import com.child1.hospital.dto.response.DoctorResponse;
import com.child1.hospital.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.print.Doc;
import java.util.List;


@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    @Query("""
    SELECT DISTINCT d
    FROM Doctor d
    LEFT JOIN FETCH d.appointments a
    LEFT JOIN FETCH a.patientName
""")
    List<Doctor> getAllDoctors();

    @Query("""
    SELECT DISTINCT d
    FROM Doctor d
    LEFT JOIN FETCH d.appointments a
    LEFT JOIN FETCH a.patientName
""")
    List<Doctor>  findAll();




}
