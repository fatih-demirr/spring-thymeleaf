package com.example.sprinbgoot.project.demo.dao;

import com.example.sprinbgoot.project.demo.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {
}
