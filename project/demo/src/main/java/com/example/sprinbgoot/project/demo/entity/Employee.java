package com.example.sprinbgoot.project.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "employee_name")
    private String employeeName;
    @Column(name = "employee_surname")
    private String employeeSurname;
    @Column(name = "employee_email")
    private String employeeEmail;
    @Column(name = "employee_city")
    private String employeeCity;
    //@Column(name = "employee_cv_path")
    //private String employeeCvPath;
    @Column(name = "employee_years_of_experience")
    private String employeeYearsOfExperience;
    @Column(name = "employee_social_link")
    private String employeeSocialLink;
    @Column(name = "employee_introduction")
    private String employeeIntroduction;
}
