package com.example.sprinbgoot.project.demo.service;

import com.example.sprinbgoot.project.demo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int theId);
    void save(Employee theEmployee);
    void deleteById(int theId);
}
