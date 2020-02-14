package com.contagionwatch.contagionwatch.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LandingController {
    @GetMapping("/landing")
    public String loginPage(){
        return "landing";
    }
}
