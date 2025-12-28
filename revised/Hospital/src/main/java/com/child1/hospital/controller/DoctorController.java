package com.child1.hospital.controller;


import com.child1.hospital.dto.request.AppointmentRequest;
import com.child1.hospital.dto.request.DoctorRequest;
import com.child1.hospital.dto.response.DoctorResponse;
import com.child1.hospital.model.Doctor;
import com.child1.hospital.repository.DoctorRepository;
import com.child1.hospital.service.DoctorService;
import com.child1.hospital.service.impl.DoctorServiceImpl;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/doctors")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;


    @PostConstruct
    public void init() {
        System.out.println("DoctorController initialized");
    }

    @GetMapping
    public ResponseEntity<Page<DoctorResponse>> getAllDoctors(Pageable pageable ) {
        System.out.println(pageable);
        Page<DoctorResponse> doctorResponse = doctorService.findAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(doctorResponse);
    }

    @GetMapping("/appointments")
    public ResponseEntity<List<DoctorResponse>> getAllAppoitments(){
        List<DoctorResponse> appointments= doctorService.getAllAppointments();
        return ResponseEntity.status(HttpStatus.OK).body(appointments);
    }

    @PostMapping("/{doctorId}/appointments")
    public ResponseEntity<String> createAppointment(@PathVariable Long doctorId , @Valid   @RequestBody AppointmentRequest request) {
        doctorService.createAppointment(doctorId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body("Appointment created successfully for doctor id: " + doctorId);
    }

    @PostMapping
    public ResponseEntity<String> createDoctor(@Valid  @RequestBody DoctorRequest request) {
       DoctorResponse doctor=   doctorService.createDoctor(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("Doctor created successfully with id: " + doctor.getId());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
        return ResponseEntity.status(HttpStatus.OK).body("Doctor deleted successfully with id: " + id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoctorResponse> updateDoctor(@PathVariable Long id, @Valid @RequestBody DoctorRequest request) {
        DoctorResponse updatedDoctor = doctorService.updateDoctor(id, request);
        return ResponseEntity.status(HttpStatus.OK).body(updatedDoctor);
    }

}
