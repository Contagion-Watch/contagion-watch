package com.contagionwatch.contagionwatch.controllers;

import com.contagionwatch.contagionwatch.dao.DiseaseRepository;
import com.contagionwatch.contagionwatch.dao.EntryRepository;
import com.contagionwatch.contagionwatch.dao.LocationRepository;
import com.contagionwatch.contagionwatch.models.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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

    @Autowired
    public LocationController(EntryRepository entryDao, LocationRepository locationDao, DiseaseRepository diseaseDao) {
        this.entryDao = entryDao;
        this.locationDao = locationDao;
        this.diseaseDao = diseaseDao;
    }

    @RequestMapping(value = "/location/{id}", method = RequestMethod.GET)
    public String locationInfo(@PathVariable Long id, Model model, @PageableDefault(value=5, sort = "date", direction = Sort.Direction.DESC) Pageable pageable) {
        model.addAttribute("corona", entryDao.findAllByLocation_IdAndDisease_Id(id, 1, pageable));
        model.addAttribute("ebola", entryDao.findAllByLocation_IdAndDisease_Id(id, 2, pageable));
        model.addAttribute("malaria", entryDao.findAllByLocation_IdAndDisease_Id(id, 3, pageable));
        model.addAttribute("diseases", diseaseDao.findAll());
        model.addAttribute("locations", locationDao.findAll());
        model.addAttribute("whichLocation", id);
        model.addAttribute("entry", new Entry());
        return "location";
    }
}
