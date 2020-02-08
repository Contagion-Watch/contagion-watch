//package com.contagionwatch.contagionwatch.controllers;
//
//import com.contagionwatch.contagionwatch.config.Keys;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//public class IntitialMapController {
//
//    Keys key = new Keys();
//    @GetMapping("/test-map")
//    public String mapGet(Model model){
//        model.addAttribute("key", key.getMapboxKey());
//        return "maps/intial-map";
//    }
//}
