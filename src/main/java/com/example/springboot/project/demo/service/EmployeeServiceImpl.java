package com.example.springboot.project.demo.service;

import com.example.springboot.project.demo.dao.EmployeeRepository;
import com.example.springboot.project.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
        this.employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAllByOrderByEmployeeSurnameAsc();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);
        Employee theEmployee = null;
        if(result.isPresent()){
            theEmployee = result.get();
        }
        else{
            throw new RuntimeException("Did not find employee id - " + theId);
        }
        return theEmployee;
    }

    @Override
    public void save(Employee theEmployee) {
        employeeRepository.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }


}
