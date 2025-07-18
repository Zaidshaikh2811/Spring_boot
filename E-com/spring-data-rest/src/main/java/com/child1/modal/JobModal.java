package com.child1.modal;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class JobModal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String jobName;
    private String jobDescription;
    private String jobLocation;
    private String jobType;
    private String companyName;
    private String companyDescription;
    private String salaryRange;
    private String requirements;
    private String benefits;
    private String applicationDeadline;


}
