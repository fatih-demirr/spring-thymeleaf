package com.example.springboot.project.demo.rest;

import com.example.springboot.project.demo.entity.Company;
import com.example.springboot.project.demo.service.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/companies")
public class CompanyController {
    private CompanyService companyService;

    public CompanyController(CompanyService theCompanyService) {
        this.companyService = theCompanyService;
    }

    @GetMapping()
    public String listCompanies(Model theModel){
        List<Company> theCompanies = companyService.findAll();
        theModel.addAttribute("companies", theCompanies);
        return "companies/list-companies";
    }
    @GetMapping("/{companyId}")
    public String getCompany(@PathVariable("companyId") Integer companyId, Model theModel){
        //check the errors: company does not exist etc.
        Company company = companyService.findById(companyId);
        theModel.addAttribute("company", company);
        return "companies/company-detail";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){
        Company theCompany = new Company();
        theModel.addAttribute("company", theCompany);
        return "companies/company-form";
    }

    @PostMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("companyId") int theId, Model theModel){
        Company theCompany = companyService.findById(theId);
        theModel.addAttribute("company", theCompany);
        return "companies/company-form";
    }

    @PostMapping("/save")
    public String saveCompany(@ModelAttribute("company") Company theCompany){
        companyService.save(theCompany);
        return "redirect:/companies/list";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam("companyId") int theId){
        companyService.deleteById(theId);
        return "redirect:/companies/list";
    }
}
