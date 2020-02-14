package com.contagionwatch.contagionwatch.controllers;

import com.contagionwatch.contagionwatch.dao.DiseaseRepository;
import com.contagionwatch.contagionwatch.dao.EntryRepository;
import com.contagionwatch.contagionwatch.dao.LocationRepository;
import com.contagionwatch.contagionwatch.models.Entry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;

@Controller
public class AdminController {
    private final DiseaseRepository diseaseDao;
    private final LocationRepository locationDao;
    private final EntryRepository entryDao;

    public AdminController(DiseaseRepository diseaseDao, LocationRepository locationDao, EntryRepository entryDao) {
        this.diseaseDao = diseaseDao;
        this.locationDao = locationDao;
        this.entryDao = entryDao;
    }

    @RequestMapping(path = "/admin", method = RequestMethod.GET)
    public String getAdmin(Model model){
        model.addAttribute("diseases", diseaseDao.findAll());
        model.addAttribute("locations", locationDao.findAll());
        model.addAttribute("entry", new Entry());
        return "admin";
    }

    @RequestMapping(path = "/admin", method = RequestMethod.POST)
    public String postAdmin(@ModelAttribute Entry entry){
        if(entry.getDate() != null && entry.getDisease() != null && entry.getLocation() != null ){
            entryDao.save(entry);
        }
        return "redirect:/admin";
    }
}
