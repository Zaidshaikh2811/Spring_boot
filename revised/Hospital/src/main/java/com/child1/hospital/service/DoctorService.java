package com.child1.hospital.service;


import com.child1.hospital.dto.request.AppointmentRequest;
import com.child1.hospital.dto.request.DoctorRequest;
import com.child1.hospital.dto.response.DoctorResponse;
import jakarta.validation.Valid;


import java.util.List;


public interface DoctorService {
    DoctorResponse createDoctor(DoctorRequest request);
    DoctorResponse getDoctorById(Long id);
    List<DoctorResponse> getAllDoctors();
    DoctorResponse updateDoctor(Long id, DoctorRequest request);
    void deleteDoctor(Long id);
    List<DoctorResponse> getAllAppointments();
    void createAppointment(Long doctorId, @Valid AppointmentRequest request);
}
