package com.contagionwatch.contagionwatch.controllers;

import com.contagionwatch.contagionwatch.dao.DiseaseRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class InformationController {
    private final DiseaseRepository diseaseDao;

    public InformationController(DiseaseRepository diseaseDao) {
        this.diseaseDao = diseaseDao;
    }

    @RequestMapping(value = "/information/{id}", method = RequestMethod.GET)
    public String diseaseInfo(@PathVariable Long id, Model model) {
        model.addAttribute("disease", diseaseDao.getDiseaseById(id));
        return "information";
    }

}
