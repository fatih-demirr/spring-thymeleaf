package com.example.sprinbgoot.project.demo.dao;

import com.example.sprinbgoot.project.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    public List<Employee> findAllByOrderByEmployeeSurnameAsc();
}
