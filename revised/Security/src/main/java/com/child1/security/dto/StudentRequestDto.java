package com.child1.security.dto;

import com.child1.security.model.Department;
import jakarta.validation.constraints.*;

public class StudentRequestDto {

    @NotBlank
    @Size(min = 2, max = 30)
    private String name;

    @NotBlank
    @Size(min = 2, max = 30)
    private String surname;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&+=]).*$",
            message = "Password must contain 1 uppercase, 1 number, 1 special character"
    )
    private String password;

    @NotBlank
    private String role;

    private String  department_name;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getDepartment() {
        return department_name;
    }
    public void setDepartment(String department_name) {
        this.department_name = department_name;
    }

    public StudentRequestDto(String name, String surname, String email, String password, String role , String department_name) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.role = role;
        this.department_name = department_name;
    }



}