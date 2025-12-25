package com.child1.hospital.dto.response;


import com.child1.hospital.dto.response.Patient.Appointments.AppointmentResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PatientResponse {
    private Long id;
    private String name;
    private String email;
    private List<AppointmentResponse> appointments;
}
