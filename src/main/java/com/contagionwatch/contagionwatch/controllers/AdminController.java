package com.contagionwatch.contagionwatch.controllers;

import com.contagionwatch.contagionwatch.dao.AdminRepository;
import com.contagionwatch.contagionwatch.dao.DiseaseRepository;
import com.contagionwatch.contagionwatch.dao.EntryRepository;
import com.contagionwatch.contagionwatch.dao.LocationRepository;
import com.contagionwatch.contagionwatch.models.Admin;
import com.contagionwatch.contagionwatch.models.Entry;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@Controller
public class AdminController {
    private final DiseaseRepository diseaseDao;
    private final LocationRepository locationDao;
    private final EntryRepository entryDao;
    private final AdminRepository adminDao;
    private final PasswordEncoder passwordEncoder;

    public AdminController(DiseaseRepository diseaseDao, LocationRepository locationDao, EntryRepository entryDao,AdminRepository adminDao ,PasswordEncoder passwordEncoder) {
        this.diseaseDao = diseaseDao;
        this.locationDao = locationDao;
        this.entryDao = entryDao;
        this.adminDao = adminDao;
        this.passwordEncoder = passwordEncoder;
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
