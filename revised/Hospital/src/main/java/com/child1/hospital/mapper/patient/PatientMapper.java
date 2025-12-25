package com.child1.hospital.mapper.patient;

import com.child1.hospital.dto.request.PatientRequest;

import com.child1.hospital.dto.response.Patient.Appointments.AppointmentResponse;
import com.child1.hospital.dto.response.PatientResponse;
import com.child1.hospital.mapper.AppointmentMapper;
import com.child1.hospital.model.Appointment;
import com.child1.hospital.model.Patient;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class PatientMapper {

    public PatientResponse  toPatientResponse(Patient patient) {
        PatientResponse patientResponse = new PatientResponse();
        patientResponse.setId(patient.getId());
        patientResponse.setName(patient.getName());
        patientResponse.setEmail(patient.getEmail());

        if(patient.getAppointments() != null) {
            patientResponse.setAppointments(
                    patient.getAppointments()
                            .stream()
                            .map(PatientMapper::toAppointmentResponse)
                            .toList()
            );
        } else {
            patientResponse.setAppointments(java.util.List.of());
        }
        return patientResponse;
    }

    public Patient toEntity(PatientRequest patientRequest) {
        Patient patient = new Patient();
        patient.setName(patientRequest.getName());
        patient.setEmail(patientRequest.getEmail());
        return patient;
    }

    public List<PatientResponse> toPatientResponseList(List<Patient> patients) {
        return patients.stream()
                .map(this::toPatientResponse)
                .toList();
    }


    public static AppointmentResponse toAppointmentResponse(Appointment appointment) {
        AppointmentResponse appointmentResponse = new AppointmentResponse();
        appointmentResponse.setId(appointment.getId());
        appointmentResponse.setAppointmentTime(appointment.getAppointmentTime().toString());
        appointmentResponse.setDoctorId(appointment.getDoctor().getId());
        appointmentResponse.setDoctorName(appointment.getDoctor().getName());
        appointmentResponse.setDoctorSpecialty(appointment.getDoctor().getSpecialty());
        return appointmentResponse;
    }
}
