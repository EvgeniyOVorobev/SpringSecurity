package com.ev.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
    @GetMapping("/")
    public String getInfoForAllEmps(){
        return "viewforall";
    }
    @GetMapping("/hr_info")
    public String geetInfoOnlyForHR(){
        return "viewforhr";
    }
    @GetMapping("/manager_info")
    public String getInfoOnlyForManagers(){
        return "viewformanager";
    }
}
