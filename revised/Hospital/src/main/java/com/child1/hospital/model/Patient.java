package com.child1.hospital.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "patients")
@Getter
@Setter
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy = "patientName", cascade = CascadeType.ALL, orphanRemoval = true)
    private  List<Appointment> appointments;

}
