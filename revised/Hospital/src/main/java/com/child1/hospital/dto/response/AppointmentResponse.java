package com.child1.hospital.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class AppointmentResponse {
    private Long id;
    private String patientName;
    private LocalDateTime appointmentTime;
}
