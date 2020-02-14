package com.contagionwatch.contagionwatch.controllers;

import com.contagionwatch.contagionwatch.dao.DiseaseRepository;
import com.contagionwatch.contagionwatch.dao.EntryRepository;
import com.contagionwatch.contagionwatch.models.Entry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class InformationController {
    private final DiseaseRepository diseaseDao;
    private final EntryRepository entryDao;

    public InformationController(DiseaseRepository diseaseDao, EntryRepository entryDao) {
        this.diseaseDao = diseaseDao;
        this.entryDao = entryDao;
    }

    @RequestMapping(value = "/information/{id}", method = RequestMethod.GET)
    public String diseaseInfo(@PathVariable Long id, Model model) {
        boolean isMalaria = false;
        if (id == 3L){
            isMalaria = true;
        }
        model.addAttribute("disease", diseaseDao.getDiseaseById(id));
        List<Entry> entries = null;
        entries = entryDao.getAllByDisease_Id(id);
        model.addAttribute("entries", entries);
        model.addAttribute("isMalaria", isMalaria);
        return "information";
    }

}
