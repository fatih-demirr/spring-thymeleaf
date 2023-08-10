package com.example.springboot.project.demo.service;

import com.example.springboot.project.demo.dao.CompanyRepository;
import com.example.springboot.project.demo.entity.Company;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    @Override
    public Company updateCompany(Integer companyId, Company updatedCompany) {
        Optional<Company> optionalCompany = companyRepository.findById(companyId);
        Company existingCompany = optionalCompany.orElseThrow(()->new EntityNotFoundException("Company not found"));

        BeanUtils.copyProperties(updatedCompany, existingCompany, "id");

        return companyRepository.save(existingCompany);
    }

    @Override
    public Company createCompany(Company newCompany) {
        // Perform any additional validation or business logic if needed before saving

        // Check if a company with the same name already exists
        Company existingCompany = companyRepository.findByCompanyName(newCompany.getCompanyName());
        if (existingCompany != null) {
            // Handle the case where the company already exists (e.g., return null or throw an exception)
            // For example, you can throw a custom exception like CompanyAlreadyExistsException
            throw new EntityExistsException("Company with name " + newCompany.getCompanyName() + " already exists");
        }
        return companyRepository.save(newCompany);
    }
}
