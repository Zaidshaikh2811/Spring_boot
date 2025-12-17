package com.child1.security.model;


import com.child1.security.model.CustomAnotation.ValidRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Entity
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;



    @Column(name = "first_name", nullable = false)
    @NotBlank(message = "First Name is Required")
    @Size(min = 2, max = 30, message = "First name must be 2–30 characters")
    private String name;

    @Column(name = "last_name",nullable = false)
    @NotBlank(message = "LastName name is required")
    @Size(min = 2, max = 30, message = "Last name must be 2–30 characters")
    private String surname;

    @Column(unique = true,nullable = false)
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;


    @Column(name="role", nullable = false)
    @NotBlank(message = "Role is required")
    @ValidRole
    private String role;

    @Column(name="password", nullable = false)
    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&+=]).*$",
            message = "Password must contain 1 capital letter, 1 number, 1 special character"
    )
    private String password;

    @OneToOne(mappedBy = "studentId", cascade = CascadeType.ALL)
    private Department department;


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

    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department) {
        this.department = department;
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
