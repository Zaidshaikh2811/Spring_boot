package com.child1.hospital.service.impl;

import com.child1.hospital.dto.request.AppointmentRequest;
import com.child1.hospital.dto.request.DoctorRequest;
import com.child1.hospital.dto.response.DoctorResponse;
import com.child1.hospital.events.GetAllDoctors;
import com.child1.hospital.exception.ResourceNotFoundException;
import com.child1.hospital.mapper.AppointmentMapper;
import com.child1.hospital.mapper.DoctorMapper;
import com.child1.hospital.model.Doctor;
import com.child1.hospital.model.Patient;
import com.child1.hospital.repository.DoctorRepository;
import com.child1.hospital.repository.PatientRepository;
import com.child1.hospital.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
@Primary
public class DoctorServiceImpl implements DoctorService , InitializingBean , DisposableBean {

    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final DoctorMapper doctorMapper;
    private final AppointmentMapper appointmentMapper;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public DoctorResponse createDoctor(DoctorRequest request){
        Doctor doctor = doctorMapper.toEntity(request);
        Doctor savedDoctor = doctorRepository.save(doctor);
        return doctorMapper.toDoctorResponse(savedDoctor);
    }

    @Override
    @Transactional(readOnly = true)
    public DoctorResponse getDoctorById(Long id){
        Doctor doctor = doctorRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Doctor not found"));
        return doctorMapper.toDoctorResponse(doctor);
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable("doctors")
    public Page<DoctorResponse> findAll(Pageable pageable ){
        Page<Doctor> doctors =  doctorRepository.findAll(pageable );
        applicationEventPublisher.publishEvent(new GetAllDoctors());
        return doctorMapper.toPageDoctorResponses(doctors);
    }
    @Override
    @CachePut(value = "doctors", key = "#id")
    public DoctorResponse updateDoctor(Long id, DoctorRequest request){
        Doctor doctor = doctorRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Doctor not found"));
        doctor.setName(request.getName());
        doctor.setSpecialty(request.getSpecialty());
        Doctor updatedDoctor = doctorRepository.save(doctor);
        return doctorMapper.toDoctorResponse(updatedDoctor);
    }
    @Override
    public void deleteDoctor(Long id){
        Doctor doctor = doctorRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Doctor not found"));
        doctorRepository.delete(doctor);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DoctorResponse> getAllAppointments() {
        List<Doctor> doctors = doctorRepository.findAll();
                return doctors
                .stream()
                .map(doctorMapper::toDoctorResponse)
                .toList();
    }

    @Override
    public void createAppointment(Long doctorId, AppointmentRequest request) {
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(()-> new ResourceNotFoundException("Doctor not found"));
        Patient patient = patientRepository.findById(request.getPatientId())
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with id: " + request.getPatientId()));

        if (doctor.getAppointments() == null) {
            doctor.setAppointments(new ArrayList<>());
        }
        doctor.addAppointment(
                appointmentMapper.toEntity(request, doctor,patient)
        );
        doctorRepository.save(doctor);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("DoctorServiceImpl initialized");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DoctorServiceImpl destroyed");
    }
}
