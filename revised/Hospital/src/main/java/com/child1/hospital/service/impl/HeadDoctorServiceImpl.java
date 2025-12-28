package com.child1.hospital.service.impl;

import com.child1.hospital.dto.request.AppointmentRequest;
import com.child1.hospital.dto.request.DoctorRequest;
import com.child1.hospital.dto.response.DoctorResponse;
import com.child1.hospital.service.DoctorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service

public class HeadDoctorServiceImpl  implements DoctorService {

    @Override
    public DoctorResponse createDoctor(DoctorRequest request) {
        return null;
    }

    @Override
    public DoctorResponse getDoctorById(Long id) {
        return null;
    }

    @Override
    public Page<DoctorResponse> findAll(Pageable pageable ) {
        return null;
    }



    @Override
    public DoctorResponse updateDoctor(Long id, DoctorRequest request) {
        return null;
    }

    @Override
    public void deleteDoctor(Long id) {

    }

    @Override
    public List<DoctorResponse> getAllAppointments() {
        return List.of();
    }

    @Override
    public void createAppointment(Long doctorId, AppointmentRequest request) {

    }
}
