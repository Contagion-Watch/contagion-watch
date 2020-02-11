package com.contagionwatch.contagionwatch.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IntitialMapController {

    @GetMapping("/test-map")
    public String mapGet(){
        return "maps/intial-map";
    }
}
