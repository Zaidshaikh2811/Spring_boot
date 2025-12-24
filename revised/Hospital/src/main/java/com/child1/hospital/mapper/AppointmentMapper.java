package com.child1.hospital.mapper;


import com.child1.hospital.dto.request.AppointmentRequest;
import com.child1.hospital.dto.response.AppointmentResponse;
import com.child1.hospital.model.Appointment;
import com.child1.hospital.model.Doctor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class AppointmentMapper {
    public Appointment toEntity(AppointmentRequest request, Doctor doctor) {
        Appointment appointment = new Appointment();
        appointment.setPatientName(request.getPatientName());
        appointment.setAppointmentTime(LocalDateTime.parse(request.getAppointmentTime()));
        appointment.setDoctor(doctor);
        return appointment;
    }


    public AppointmentResponse toResponse(Appointment appointment) {
        AppointmentResponse response = new AppointmentResponse();
        response.setId(appointment.getId());
        response.setPatientName(appointment.getPatientName());
        response.setAppointmentTime(appointment.getAppointmentTime());
        return response;
    }
}
