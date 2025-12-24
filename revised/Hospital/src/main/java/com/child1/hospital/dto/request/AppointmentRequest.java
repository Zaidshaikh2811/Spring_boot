package com.child1.hospital.dto.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppointmentRequest {
    private String patientName;
    private String appointmentTime;

}
