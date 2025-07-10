package com.child1;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;


@Entity
@Table(name = "students")
@Component
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "email", nullable = false, unique = true)
    private String email;




    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "laptop_id", referencedColumnName = "id")
    private Laptop hasLaptop;



    // Constructor with parameters
    public Student() {}
    public Student(String name, String email , Laptop hasLaptop) {
        this.name = name;
        this.email = email;
        this.hasLaptop = hasLaptop;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Laptop getHasLaptop() { return hasLaptop; }
    public void setHasLaptop(Laptop hasLaptop) { this.hasLaptop = hasLaptop; }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", hasLaptop=" + hasLaptop +
                '}';
    }
}