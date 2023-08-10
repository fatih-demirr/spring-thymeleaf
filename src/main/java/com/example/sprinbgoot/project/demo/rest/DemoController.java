package com.example.sprinbgoot.project.demo.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
    @GetMapping("/hello")
    public String sayHello(Model theModel){
        theModel.addAttribute("theDate", new java.util.Date());
        return "Hello World!";
    }
    @GetMapping("/home")
    public String home(){
        return "home";
    }
    @GetMapping("/about")
    public String about(){
        return "about";
    }
    @GetMapping("sign-up")
    public String signup(){
        return "sign-up";
    }
    @GetMapping("/")
    public String showHome(){
        return "homee";
    }
    @GetMapping("/leaders")
    public String showLeaders(){
        return "leaders";
    }
    @GetMapping("/systems")
    public String showSystems(){
        return "systems";
    }
    @GetMapping("/admin")
    public String adminPanel(){
        return "admin";
    }
    @GetMapping("/employee_panel")
    public String employeePanel(){
        return "employee_panel";
    }
    @GetMapping("/company_panel")
    public String companyPanel(){
        return "company_panel";
    }
}
