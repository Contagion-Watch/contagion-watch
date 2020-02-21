package com.contagionwatch.contagionwatch.controllers;

import com.contagionwatch.contagionwatch.dao.DiseaseRepository;
import com.contagionwatch.contagionwatch.dao.EntryRepository;
import com.contagionwatch.contagionwatch.dao.LocationRepository;
import com.contagionwatch.contagionwatch.models.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class InformationController {
    private final DiseaseRepository diseaseDao;
    private final EntryRepository entryDao;
    private final LocationRepository locationDao;

    @Autowired
    public InformationController(DiseaseRepository diseaseDao, EntryRepository entryDao, LocationRepository locationDao) {
        this.diseaseDao = diseaseDao;
        this.entryDao = entryDao;
        this.locationDao = locationDao;
    }

    @Value("${bingKey}")
    private String bingKey;

    @Value("${nytKey}")
    private String nytKey;


    @RequestMapping(value = "/information/{id}", method = RequestMethod.GET)
    public String diseaseInfo(@PathVariable Long id, Model model, @PageableDefault(value=5, sort = "date", direction = Sort.Direction.DESC) Pageable pageable) {
        boolean isMalaria = false;
        if (id == 3L){
            isMalaria = true;
        }
        model.addAttribute("bingKey",bingKey);
        model.addAttribute("nytKey",nytKey);
        model.addAttribute("page", entryDao.findAllByDisease_Id(id, pageable));
        model.addAttribute("isMalaria", isMalaria);
        model.addAttribute("whichDisease", id);
        model.addAttribute("disease", diseaseDao.getDiseaseById(id));
        model.addAttribute("diseases", diseaseDao.findAll());
        model.addAttribute("locations", locationDao.findAll());
        model.addAttribute("entry", new Entry());
        return "information";
    }

}

