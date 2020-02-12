package com.contagionwatch.contagionwatch.controllers;

import com.contagionwatch.contagionwatch.dao.DiseaseRepository;
import com.contagionwatch.contagionwatch.dao.LocationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {
    private final DiseaseRepository diseaseDao;
    private final LocationRepository locationDao;

    public AdminController(DiseaseRepository diseaseDao, LocationRepository locationDao) {
        this.diseaseDao = diseaseDao;
        this.locationDao = locationDao;
    }

    @RequestMapping(path = "/admin", method = RequestMethod.GET)
    public String getAdmin(Model model){
        model.addAttribute("diseases", diseaseDao.findAll());
        model.addAttribute("locations", locationDao.findAll());
        return "admin";
    }
}
