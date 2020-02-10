package com.contagionwatch.contagionwatch.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InformationController {
    @GetMapping("/information")
    public String homePage(){
        return "information";
    }
}
