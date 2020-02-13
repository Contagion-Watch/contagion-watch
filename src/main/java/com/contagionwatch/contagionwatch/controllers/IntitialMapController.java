package com.contagionwatch.contagionwatch.controllers;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IntitialMapController {


    @Value("${mapboxKey}")
    private String mapboxKey;

    @Value("${bingKey}")
    private String bingKey;

    @Value("${nytKey}")
    private String nytKey;

    @GetMapping("/test-map")
    public String mapGet(Model model){
        model.addAttribute("mapboxKey",mapboxKey);
        return "maps/intial-map";
    }

    @GetMapping("/test-api")
    public String getApi(Model model){
        model.addAttribute("nytKey",nytKey);
        model.addAttribute("bingKey",bingKey);
        return"maps/news-api-test";
    }
}
