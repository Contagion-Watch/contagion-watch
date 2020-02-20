package com.contagionwatch.contagionwatch.controllers;


import com.contagionwatch.contagionwatch.dao.LocationRepository;
import com.contagionwatch.contagionwatch.models.Location;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class LocationNavigationController {
    private final LocationRepository locationDao;

    public LocationNavigationController(LocationRepository locationDao){
        this.locationDao = locationDao;
    }

    @GetMapping(path = "/location-navigation/api/locations")
    @ResponseBody
    public List<Location> getAllLocations(){
        return locationDao.findAll();
    }

    @GetMapping(path = "/location-navigation")
    public String locationNavigation(){
        return "location_navigation";
    }
}
