package com.example.springboot.project.demo.service;

import com.example.springboot.project.demo.entity.Company;

import java.util.List;

public interface CompanyService {
    List<Company> findAll();

    Company findById(int theId);

    void save(Company theCompany);

    void deleteById(int theId);
}
