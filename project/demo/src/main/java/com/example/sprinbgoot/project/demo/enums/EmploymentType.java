package com.example.sprinbgoot.project.demo.enums;

public enum EmploymentType {
    B2B("B2B"),
    PERMENANT("Permenant"),
    MANDATE_CONTRACT("Mandate Contract");
    private final String employmentType;
    EmploymentType(String employmentType){
        this.employmentType = employmentType;
    }
    public String getEmploymentType(){
        return employmentType;
    }
}
