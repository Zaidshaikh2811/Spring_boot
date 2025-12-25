package com.child1.hospital.mapper;


import com.child1.hospital.dto.request.AppointmentRequest;
import com.child1.hospital.dto.response.AppointmentResponse;
import com.child1.hospital.mapper.patient.PatientMapper;
import com.child1.hospital.model.Appointment;
import com.child1.hospital.model.Doctor;
import com.child1.hospital.model.Patient;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class AppointmentMapper {
    public Appointment toEntity(AppointmentRequest request, Doctor doctor, Patient patient) {
        Appointment appointment = new Appointment();
        appointment.setPatientName(patient);
        appointment.setAppointmentTime(LocalDateTime.parse(request.getAppointmentTime()));
        appointment.setDoctor(doctor);
        return appointment;
    }


    public AppointmentResponse toResponse(Appointment appointment) {
        AppointmentResponse response = new AppointmentResponse();
        response.setId(appointment.getId());
        response.setPatientName(appointment.getPatientName().getName());
        response.setAppointmentTime(appointment.getAppointmentTime());
        return response;
    }



}
