package com.child1;


import org.springframework.stereotype.Component;

@Component
public class Student {
    private String name;
    private int age;
    private String grade;
    private String address;
    private String email;

    public Student() {}

    public Student(String name, int age, String grade, String address, String email) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.address = address;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", grade='" + grade + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                java.util.Objects.equals(name, student.name) &&
                java.util.Objects.equals(grade, student.grade) &&
                java.util.Objects.equals(address, student.address) &&
                java.util.Objects.equals(email, student.email);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(name, age, grade, address, email);
    }
}
