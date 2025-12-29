package com.child1.hospital.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;

import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
@Getter
@Setter
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime appointmentTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
//    @BatchSize(size = 20)
    private Patient patientName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
//    @BatchSize(size = 20)
    private Doctor doctor;

    public String getDetails() {
        return "Appointment{id=" + id + ", appointmentTime=" + appointmentTime + ", patientName='" + patientName + "'}";
    }


}
