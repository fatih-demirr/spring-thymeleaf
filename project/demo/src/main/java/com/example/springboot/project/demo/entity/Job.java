package com.example.springboot.project.demo.entity;

import com.example.springboot.project.demo.enums.EmploymentType;
import com.example.springboot.project.demo.enums.ExpertiseLevel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.Set;

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
    private Integer salaryMax;
    @Column(name = "salary_min")
    private Integer salaryMin;
    @Column(name = "date_post")
    private LocalDate dateOfPost;
    @Column(name = "is_remote")
    private Boolean isRemote;
    @Column(name = "is_salary_disclosed")
    private Boolean isSalaryDisclosed;
    @JsonIgnore
    @ManyToMany(mappedBy = "appliedJobs")
    private Set<Employee> appliedEmployees = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "company_id",referencedColumnName = "id", nullable = false)
    private Company company;
    @Transient
    private String timeInfo;
    @Transient
    private String salaryInfo;
    /*@ElementCollection
    private List<String> techStack;*/

    public String getTimeInfo() {
        Period period = Period.between(dateOfPost,LocalDate.now());
        if(period.getDays() < 7){
            return "New";
        }
        if(period.getMonths() < 1){
            return period.getDays()/7 + " weeks ago";
        }
        if(period.getYears() < 1){
            return period.getMonths() + " months ago";
        }

        return period.getYears() + " years ago";
    }

    public String getSalaryInfo() {
        if(!isSalaryDisclosed){
            return "Undisclosed Salary";
        }

        return salaryMin + " - " + salaryMax;
    }
}
