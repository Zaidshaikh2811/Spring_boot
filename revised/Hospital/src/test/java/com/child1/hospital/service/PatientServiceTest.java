package com.child1.hospital.service;

import com.child1.hospital.dto.response.PatientResponse;
import com.child1.hospital.mapper.patient.PatientMapper;
import com.child1.hospital.model.Patient;
import com.child1.hospital.repository.PatientRepository;
import com.child1.hospital.service.impl.PatientServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PatientServiceTest {

    @InjectMocks
    PatientServiceImpl patientService ;
    @Mock
    PatientMapper patientMapper ;
    @Mock
    PatientRepository patientRepository;

    @Test
    void getAllPatientsSuccessfully() {

        System.out.println("----- Get All Patients Test -----");

        Patient patient1 = new Patient();
        patient1.setId(1L);
        patient1.setName("John Doe");
        Patient patient2 = new Patient();
        patient2.setId(2L);
        patient2.setName("Jane Smith");

        List<Patient> patientList = List.of(patient1,patient2);

        when(patientRepository.findAll()).thenReturn(patientList);

        PatientResponse response1 = new PatientResponse();
        response1.setId(1L);
        response1.setName("John Doe");

        PatientResponse response2 = new PatientResponse();
        response2.setId(2L);
        response2.setName("Jane Smith");

        when(patientMapper.toPatientResponse(patient1)).thenReturn(response1);
        when(patientMapper.toPatientResponse(patient2)).thenReturn(response2);

        List<PatientResponse> patients  = patientService.getAllPatients();
        System.out.println(" Number of Patients: " + patients.size());
        for (PatientResponse item : patients) {
            System.out.println(item);
        }


        assertEquals(patient1.getName(),response1.getName());
    }

}
