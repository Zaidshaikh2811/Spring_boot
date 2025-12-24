package com.child1.hospital.dto.response;


import com.child1.hospital.model.Appointment;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DoctorResponse {
    private Long id;
    private String name;
    private String specialty;
    private List<AppointmentResponse> appointments;



}
