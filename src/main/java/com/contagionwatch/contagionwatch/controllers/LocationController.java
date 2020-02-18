package com.contagionwatch.contagionwatch.controllers;

import com.contagionwatch.contagionwatch.dao.DiseaseRepository;
import com.contagionwatch.contagionwatch.dao.EntryRepository;
import com.contagionwatch.contagionwatch.dao.LocationRepository;
import com.contagionwatch.contagionwatch.models.Entry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class LocationController {
    private final EntryRepository entryDao;
    private final LocationRepository locationDao;
    private final DiseaseRepository diseaseDao;

    public LocationController(EntryRepository entryDao, LocationRepository locationDao, DiseaseRepository diseaseDao) {
        this.entryDao = entryDao;
        this.locationDao = locationDao;
        this.diseaseDao = diseaseDao;
    }

    @RequestMapping(value = "/location/{id}", method = RequestMethod.GET)
    public String locationInfo(@PathVariable Long id, Model model) {
        List<Entry> corona = null;
        List<Entry> ebola = null;
        List<Entry> malaria = null;
        corona = entryDao.getAllByDisease_IdAndLocation_Id(1L, id);
        ebola = entryDao.getAllByDisease_IdAndLocation_Id(2L, id);
        malaria = entryDao.getAllByDisease_IdAndLocation_Id(3L, id);
        model.addAttribute("diseases", diseaseDao.findAll());
        model.addAttribute("locations", locationDao.findAll());
        model.addAttribute("entry", new Entry());
        model.addAttribute("corona", corona);
        model.addAttribute("ebola", ebola);
        model.addAttribute("malaria", malaria);
        return "location";
    }
}
