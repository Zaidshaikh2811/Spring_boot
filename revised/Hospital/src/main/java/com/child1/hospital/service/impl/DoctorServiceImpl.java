package com.child1.hospital.service.impl;

import com.child1.hospital.dto.request.AppointmentRequest;
import com.child1.hospital.dto.request.DoctorRequest;
import com.child1.hospital.dto.response.DoctorResponse;
import com.child1.hospital.exception.ResourceNotFoundException;
import com.child1.hospital.mapper.AppointmentMapper;
import com.child1.hospital.mapper.DoctorMapper;
import com.child1.hospital.model.Doctor;
import com.child1.hospital.model.Patient;
import com.child1.hospital.repository.DoctorRepository;
import com.child1.hospital.repository.PatientRepository;
import com.child1.hospital.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final DoctorMapper doctorMapper;
    private final AppointmentMapper appointmentMapper;

    @Override
    @Transactional
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
    public List<DoctorResponse> getAllDoctors(){
        List<Doctor> doctors =  doctorRepository.getAllDoctors();
        return doctorMapper.toDoctorResponses(doctors);
    }
    @Override
    @Transactional
    public DoctorResponse updateDoctor(Long id, DoctorRequest request){
        Doctor doctor = doctorRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Doctor not found"));
        doctor.setName(request.getName());
        doctor.setSpecialty(request.getSpecialty());
        Doctor updatedDoctor = doctorRepository.save(doctor);
        return doctorMapper.toDoctorResponse(updatedDoctor);
    }
    @Override
    @Transactional
    public void deleteDoctor(Long id){
        Doctor doctor = doctorRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Doctor not found"));
        doctorRepository.delete(doctor);
    }

    @Override
    public List<DoctorResponse> getAllAppointments() {
        List<Doctor> doctors = doctorRepository.findAll();
                return doctors
                .stream()
                .map(doctorMapper::toDoctorResponse)
                .toList();
    }

    @Override
    @Transactional
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
}
