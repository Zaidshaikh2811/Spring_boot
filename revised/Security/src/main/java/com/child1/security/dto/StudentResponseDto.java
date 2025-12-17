package com.child1.security.dto;

public class StudentResponseDto {

    private Integer id;
    private String name;
    private String surname;
    private String email;
    private String role;

    public StudentResponseDto(Integer id, String name, String surname, String email, String role) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.role = role;
    }


}