package com.child1.hospital.dto.response.Patient.Appointments;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AppointmentResponse {
    private Long id;
        private String appointmentTime;
        private Long doctorId;
        private String doctorName;
        private String doctorSpecialty;
}
