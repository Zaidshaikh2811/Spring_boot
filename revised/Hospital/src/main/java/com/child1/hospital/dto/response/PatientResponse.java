package com.child1.hospital.dto.response;


import com.child1.hospital.dto.response.Patient.Appointments.AppointmentResponse;
import com.child1.hospital.model.Patient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatientResponse {
    private Long id;
    private String name;
    private String email;
    private List<AppointmentResponse> appointments;


}
