package com.example.springboot.project.demo.rest;

import com.example.springboot.project.demo.entity.Company;
import com.example.springboot.project.demo.entity.Job;
import com.example.springboot.project.demo.service.JobServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

//@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "Access-Control-Allow-Origin")
@Controller
@RequestMapping("/jobs")
public class JobController {
    private final JobServiceImpl jobService;
    @Autowired
    public JobController(JobServiceImpl jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/list")
    public String getAllJobs(Model theModel){
        List<Job> jobList = jobService.getAllJobs();
        theModel.addAttribute("jobs", jobList);
        return "jobs/list-jobs";
    }

    @GetMapping("/{jobId}")
    public ResponseEntity<Job> getJob(@PathVariable("jobId") Integer jobId){
        //check the errors: job does not exist etc.
        Job job = jobService.findJobById(jobId).get();
        return ResponseEntity.ok(job);
    }

    @DeleteMapping("/{jobId}")
    public ResponseEntity<Void> deleteCompany(@PathVariable Integer jobId) {
        if (jobService.deleteJob(jobId)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/companies/{companyId}/jobs")
    public ResponseEntity<Job> createJob(
            @PathVariable Integer companyId,
            @RequestBody Job newJob) {
        // Perform any necessary validation or business logic before saving
        // For example, check if the newJob has all the required fields, etc.

        // Save the new company in the database
        Job savedJob = jobService.createJob(companyId, newJob);

        return ResponseEntity.ok(savedJob);
    }

    @PutMapping("/jobs/{jobId}")
    public ResponseEntity<Job> updateJob(
            @PathVariable Integer jobId,
            @RequestBody Job updatedJob
    ) {
        // Retrieve the existing company from the database
        Job existingJob = jobService.getJobById(jobId);

        // Save the updated company in the database
        updatedJob = jobService.updateJob(jobId, updatedJob);

        return ResponseEntity.ok(updatedJob);
    }
}
