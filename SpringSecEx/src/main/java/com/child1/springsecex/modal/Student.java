package com.child1.springsecex.modal;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter


public class Student {

    private Long id;
    private String name;
    private String email;
    private String password;



    @Override
    public String toString() {
        return super.toString();
    }
}
