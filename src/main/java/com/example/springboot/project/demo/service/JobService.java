package com.example.springboot.project.demo.service;

import com.example.springboot.project.demo.entity.Job;

import java.util.List;
import java.util.Optional;

public interface JobService {
    Optional<Job> findJobById(Integer JobId);
    List<Job> getAllJobs();
    Job getJobById(Integer jobId);
    boolean deleteJob(Integer jobId);
    Job createJob(Integer companyId, Job newJob);
    Job updateJob(Integer jobId, Job updatedJob);
}