package com.child1.security.model;


import jakarta.persistence.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;



    @Column(name = "first_name")
    private String name;
    @Column(name = "last_name")
    private String surname;
    @Column(unique = true)
    private String email;
    @Column(name="role")
    private String role;
    @Column(name="password")
    private String password;

    public Student() {

    }

    public Student(String name, String surname, String email, String password,String role) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.role = role;
    }




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public String getRole(){
        return  role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }


    @PrePersist
    @PreUpdate
    private void encryptPassword() {
        if (this.password != null && !this.password.startsWith("$2a$")) {
            this.password = new BCryptPasswordEncoder().encode(this.password);
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
