package com.example.springboot.project.demo.enums;

public enum ExpertiseLevel {
    SENIOR("Senior"),
    MID("Mid"),
    JUNIOR("Junior");
    private final String level;
    ExpertiseLevel(String level){
        this.level = level;
    }
    public String getLevel(){
        return level;
    }
}
