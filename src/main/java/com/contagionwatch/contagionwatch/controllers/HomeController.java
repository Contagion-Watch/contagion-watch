package com.contagionwatch.contagionwatch.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String loginPage(){
        return "home";
    }
    @GetMapping("/")
    public String loginPageTwo(){
        return "home";
    }
    @GetMapping("")
    public String loginPageThree(){
        return "home";
    }
}
