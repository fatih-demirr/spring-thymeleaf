package com.example.sprinbgoot.project.demo.entity;

import com.example.sprinbgoot.project.demo.enums.EmploymentType;
import com.example.sprinbgoot.project.demo.enums.ExpertiseLevel;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "job")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "job_name")
    private String jobName;
    @Column(name = "job_description")
    private String jobDescription;
    @Column(name = "employment_type")
    private EmploymentType employmentType;
    @Column(name = "expertise_level")
    private ExpertiseLevel expertiseLevel;
    @Column(name = "salary_max")
    private String salaryMax;
    @Column(name = "salary_min")
    private String salaryMin;
}
