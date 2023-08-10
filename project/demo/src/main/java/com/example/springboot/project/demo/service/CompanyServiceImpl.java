package com.example.springboot.project.demo.service;

import com.example.springboot.project.demo.dao.CompanyRepository;
import com.example.springboot.project.demo.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService{
    private CompanyRepository companyRepository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository theCompanyRepository) {
        this.companyRepository = theCompanyRepository;
    }

    @Override
    public List<Company> findAll() {
        return companyRepository.findAllByOrderByCompanyNameAsc();
    }

    @Override
    public Company findById(int theId) {
        Optional<Company> result = companyRepository.findById(theId);
        Company theCompany = null;
        if(result.isPresent()){
            theCompany = result.get();
        }
        else{
            throw new RuntimeException("Did not find company id - " + theId);
        }
        return theCompany;
    }

    @Override
    public void save(Company theCompany) {
        companyRepository.save(theCompany);
    }

    @Override
    public void deleteById(int theId) {
        companyRepository.deleteById(theId);
    }
}
