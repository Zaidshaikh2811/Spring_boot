package com.child1.security.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "department")
public class Department {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, unique = true)
    @NotBlank(message = "Department Name is Required")
    private String name;


    @OneToOne
    @JoinColumn(  name = "student_id",
            referencedColumnName = "id",
            unique = true,
            nullable = false)
    private Student studentId;




    public Department() {
    }
    public Department(String name, Student studentId) {
        this.name = name;
        this.studentId = studentId;
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
    public Student getStudentId() {
        return studentId;
    }
    public void setStudentId(Student studentId) {
        this.studentId = studentId;
    }


}
