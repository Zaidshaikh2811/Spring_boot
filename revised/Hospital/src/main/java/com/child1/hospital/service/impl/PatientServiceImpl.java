package com.child1.hospital.service.impl;


import com.child1.hospital.dto.response.PatientResponse;
import com.child1.hospital.mapper.patient.PatientMapper;
import com.child1.hospital.repository.PatientRepository;
import com.child1.hospital.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;


    public PatientServiceImpl(PatientRepository patientRepository, PatientMapper patientMapper) {
        this.patientRepository = patientRepository;
        this.patientMapper = patientMapper;
    }

    public List<PatientResponse> getAllPatients() {
        return patientRepository.findAll()
                .stream()
                .map(patientMapper::toPatientResponse)
                .toList();
    }
}
