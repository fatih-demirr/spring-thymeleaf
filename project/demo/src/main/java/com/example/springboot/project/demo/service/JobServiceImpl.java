package com.example.springboot.project.demo.service;

import com.example.springboot.project.demo.entity.Company;
import com.example.springboot.project.demo.entity.Employee;
import com.example.springboot.project.demo.entity.Job;
import com.example.springboot.project.demo.dao.CompanyRepository;
import com.example.springboot.project.demo.dao.JobRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService{
    private final JobRepository jobRepository;
    private final CompanyRepository companyRepository;
    @Autowired
    public JobServiceImpl(JobRepository jobRepository, CompanyRepository companyRepository) {
        this.jobRepository = jobRepository;
        this.companyRepository = companyRepository;
    }

    public Optional<Job> findJobById(Integer JobId){
        return jobRepository.findById(JobId);
    }
    public List<Job> getAllJobs(){
        return jobRepository.findAll();
    }

    public Job getJobById(Integer jobId) {
        Optional<Job> optionalJob = jobRepository.findById(jobId);

        // If the job with the given ID exists, return it; otherwise, return null
        return optionalJob.orElse(null);
    }

    public boolean deleteJob(Integer jobId) {
        Optional<Job> optionalJob = jobRepository.findById(jobId);

        if (optionalJob.isPresent()) {
            for(Employee employee: optionalJob.get().getAppliedEmployees()){
                employee.getAppliedJobs().remove(optionalJob.get());
            }
            jobRepository.deleteById(jobId);
            return true;
        }
        return false;
    }

    public Job createJob(Integer companyId, Job newJob)  {
        // Perform any additional validation or business logic if needed before saving
        Optional<Company> companyOptional = companyRepository.findById(companyId);

        if(companyOptional.isPresent()){
            newJob.setCompany(companyOptional.get());

            return jobRepository.save(newJob);
        }

        // Check if a company with the same name already exists
        // Handle the case where the company already exists (e.g., return null or throw an exception)
        // For example, you can throw a custom exception like CompanyAlreadyExistsException
        return null;
    }

    @Transactional
    public Job updateJob(Integer jobId, Job updatedJob) {
        Optional<Job> optionalJob = jobRepository.findById(jobId);

        if (optionalJob.isPresent()) {
            Job existingJob = optionalJob.get();

            // Update properties of the existing company with the properties of the updatedCompany
            if(updatedJob.getJobName() != null){
                existingJob.setJobName(updatedJob.getJobName());
            }
            if(updatedJob.getJobDescription() != null){
                existingJob.setJobDescription(updatedJob.getJobDescription());
            }
            if(updatedJob.getEmploymentType() != null){
                existingJob.setEmploymentType(updatedJob.getEmploymentType());
            }
            if(updatedJob.getExpertiseLevel() != null){
                existingJob.setExpertiseLevel(updatedJob.getExpertiseLevel());
            }
            if(updatedJob.getIsRemote() != null){
                existingJob.setIsRemote(updatedJob.getIsRemote());
            }
            if(updatedJob.getIsSalaryDisclosed() != null){
                existingJob.setIsSalaryDisclosed(updatedJob.getIsSalaryDisclosed());
            }
            if(updatedJob.getSalaryMin() != null){
                existingJob.setSalaryMin(updatedJob.getSalaryMin());
            }
            if(updatedJob.getSalaryMax() != null){
                existingJob.setSalaryMax(updatedJob.getSalaryMax());
            }
            // Update other properties as needed...

            // Save the updated company back to the database
            return jobRepository.save(existingJob);
        }

        // Return null if the company with the given ID is not found
        return null;
    }
}
