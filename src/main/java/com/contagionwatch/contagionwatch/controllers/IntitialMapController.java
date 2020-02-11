package com.contagionwatch.contagionwatch.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IntitialMapController {

    @Value("${mapboxKey}")
    private String mapboxKey;

    @GetMapping("/test-map")
    public String mapGet(Model model){
        model.addAttribute("mapboxKey",mapboxKey);
        return "maps/intial-map";
    }
}
