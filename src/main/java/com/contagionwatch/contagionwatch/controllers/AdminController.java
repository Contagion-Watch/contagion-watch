package com.contagionwatch.contagionwatch.controllers;

import com.contagionwatch.contagionwatch.dao.DiseaseRepository;
import com.contagionwatch.contagionwatch.dao.EntryRepository;
import com.contagionwatch.contagionwatch.dao.LocationRepository;
import com.contagionwatch.contagionwatch.dao.NewsRepository;
import com.contagionwatch.contagionwatch.models.Entry;
import com.contagionwatch.contagionwatch.models.News;
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
    private final NewsRepository newsDao;

    public AdminController(DiseaseRepository diseaseDao, LocationRepository locationDao, EntryRepository entryDao,NewsRepository newsDao) {
        this.diseaseDao = diseaseDao;
        this.locationDao = locationDao;
        this.entryDao = entryDao;
        this.newsDao = newsDao;
    }

    @RequestMapping(path = "/admin", method = RequestMethod.GET)
    public String getAdmin(Model model){
        model.addAttribute("diseases", diseaseDao.findAll());
        model.addAttribute("locations", locationDao.findAll());
        model.addAttribute("entry", new Entry());
        model.addAttribute("news",new News());
        return "admin";
    }

    @RequestMapping(path = "/admin", method = RequestMethod.POST)
    public String postAdmin(@ModelAttribute Entry entry,@ModelAttribute News news){
        if(entry.getDate() != null && entry.getDisease() != null && entry.getLocation() != null ){
            entryDao.save(entry);
        }
        if(news.getDate() != null && news.getDisease() != null && news.getLocation() != null && news.getImageURL() != null){
            newsDao.save(news);
        }
        return "redirect:/admin";
    }
}
