package com.child1.hospital.service;

import com.child1.hospital.dto.response.PatientResponse;


import java.util.List;

public interface PatientService {


    List<PatientResponse> getAllPatients();
}
