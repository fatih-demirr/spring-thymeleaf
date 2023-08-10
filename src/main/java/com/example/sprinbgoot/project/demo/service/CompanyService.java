package com.example.sprinbgoot.project.demo.service;

import com.example.sprinbgoot.project.demo.entity.Company;

import java.util.List;

public interface CompanyService {
    List<Company> findAll();

    Company findById(int theId);

    void save(Company theCompany);

    void deleteById(int theId);
}
