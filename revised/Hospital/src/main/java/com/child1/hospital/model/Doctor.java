package com.child1.hospital.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    @NotBlank(message = "Name is mandatory")
    @Size(min = 2,max = 100, message = "Name can have at most 100 characters")
    private String name;

    @Column(name = "specialty", nullable = false)
    @NotBlank(message = "Specialty is mandatory")
    @Size(min = 2, max = 100, message = "Specialty can have at most 100 characters")
    private String specialty;

    @Column(name = "appointments")
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Appointment> appointments;

    public void addAppointment(Appointment entity) {
        appointments.add(entity);
        entity.setDoctor(this);
    }
}
