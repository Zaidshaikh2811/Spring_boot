package com.child1.hospital.mapper;


import com.child1.hospital.dto.request.DoctorRequest;
import com.child1.hospital.dto.response.DoctorResponse;
import com.child1.hospital.model.Doctor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DoctorMapper {

    public DoctorResponse doctorToDoctorResponse(Doctor doctor){
        DoctorResponse response=new DoctorResponse();
        response.setId(doctor.getId());
        response.setName(doctor.getName());
        response.setSpecialty(doctor.getSpecialty());
        return response;
    }

    public Doctor doctorResponseToDoctor(DoctorResponse response){
        Doctor doctor=new Doctor();
        doctor.setId(response.getId());
        doctor.setName(response.getName());
        doctor.setSpecialty(response.getSpecialty());
        return doctor;
    }

    public DoctorResponse doctorToDoctorResponseSimple(Doctor doctor){
        DoctorResponse response=new DoctorResponse();
        response.setId(doctor.getId());
        response.setName(doctor.getName());
        return response;
    }

    public Doctor toEntity(DoctorRequest request){
        Doctor doctor=new Doctor();
        doctor.setName(request.getName());
        doctor.setSpecialty(request.getSpecialty());
        return doctor;
    }


    public List<DoctorResponse> doctorsToDoctorResponses(List<Doctor> doctors) {
        return doctors.stream().map(this::doctorToDoctorResponse).toList();
    }
}
