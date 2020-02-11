package com.contagionwatch.contagionwatch.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArchiveController {
    @GetMapping("/archive")
    public String archivePage(){
        return "archive";
    }
}
