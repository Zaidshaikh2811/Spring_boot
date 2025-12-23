package com.child1.hospital.service.impl;

import com.child1.hospital.dto.request.DoctorRequest;
import com.child1.hospital.dto.response.DoctorResponse;
import com.child1.hospital.exception.ResourceNotFoundException;
import com.child1.hospital.mapper.DoctorMapper;
import com.child1.hospital.model.Doctor;
import com.child1.hospital.repository.DoctorRepository;
import com.child1.hospital.service.DoctorService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    DoctorRepository doctorRepository;
    DoctorMapper doctorMapper;


    @Override
    @Transactional
    public DoctorResponse createDoctor(DoctorRequest request){
        Doctor doctor = doctorMapper.toEntity(request);
        Doctor savedDoctor = doctorRepository.save(doctor);
        return doctorMapper.doctorToDoctorResponse(savedDoctor);
    }
    public DoctorResponse getDoctorById(Long id){
        Doctor doctor = doctorRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Doctor not found"));
        return doctorMapper.doctorToDoctorResponse(doctor);
    }
    public List<DoctorResponse> getAllDoctors(){
        List<Doctor> doctors = doctorRepository.findAll();
        return doctorMapper.doctorsToDoctorResponses(doctors);
    }
    public DoctorResponse updateDoctor(Long id, DoctorRequest request){
        Doctor doctor = doctorRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Doctor not found"));
        doctor.setName(request.getName());
        doctor.setSpecialty(request.getSpecialty());
        Doctor updatedDoctor = doctorRepository.save(doctor);
        return doctorMapper.doctorToDoctorResponse(updatedDoctor);
    }
    public void deleteDoctor(Long id){
        Doctor doctor = doctorRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Doctor not found"));
        doctorRepository.delete(doctor);
    }
}
