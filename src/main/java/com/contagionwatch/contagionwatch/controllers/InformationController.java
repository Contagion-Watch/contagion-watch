package com.contagionwatch.contagionwatch.controllers;

import com.contagionwatch.contagionwatch.dao.DiseaseRepository;
import com.contagionwatch.contagionwatch.dao.EntryRepository;
import com.contagionwatch.contagionwatch.dao.LocationRepository;
import com.contagionwatch.contagionwatch.models.Entry;
import com.mysql.cj.xdevapi.JsonArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.json.*;
import org.json.JSONException;

import org.json.JSONObject;

import java.util.ArrayList;
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


    @RequestMapping(value = "/information/{id}", method = RequestMethod.GET)
    public String diseaseInfo(@PathVariable Long id, Model model, @PageableDefault(value=5, sort = "date") Pageable pageable) {
        boolean isMalaria = false;
        if (id == 3L){
            isMalaria = true;
        }
        model.addAttribute("page", entryDao.findAllByDisease_Id(id, pageable));
        model.addAttribute("isMalaria", isMalaria);
        model.addAttribute("whichDisease", id);

        model.addAttribute("disease", diseaseDao.getDiseaseById(id));
        List<Entry> entries = null;
        entries = entryDao.getAllByDisease_Id(id);
        model.addAttribute("diseases", diseaseDao.findAll());
        model.addAttribute("locations", locationDao.findAll());
        model.addAttribute("entry", new Entry());
        model.addAttribute("entries", entries);
        return "information";
    }

}

