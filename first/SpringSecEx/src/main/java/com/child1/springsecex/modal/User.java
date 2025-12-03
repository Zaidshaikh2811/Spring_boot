package com.child1.springsecex.modal;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = "username")})
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "Username must not be blank")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    private String username;


    @Column(nullable = false)
    @NotBlank(message = "Password must not be blank")
    @Size(min = 6, max = 100, message = "Password must be between 6 and 100 characters")
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;

    @Column(nullable = false)
    private Boolean enabled = true;



    public enum Role {
        USER, ADMIN, MODERATOR
    }

    public User(String username, String password, Role role, Boolean enabled) {
        this.username = username;
        this.password = password;
        this.role = role != null ? role : Role.USER;
        this.enabled = enabled != null ? enabled : true;
    }


}
