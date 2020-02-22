package com.contagionwatch.contagionwatch.controllers;


import com.contagionwatch.contagionwatch.dao.EntryRepository;
import com.contagionwatch.contagionwatch.dao.LocationRepository;
import com.contagionwatch.contagionwatch.models.Entry;
import com.contagionwatch.contagionwatch.models.Location;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LocationNavigationController {
    private final LocationRepository locationDao;
    private final EntryRepository entryDao;

    public LocationNavigationController(LocationRepository locationDao, EntryRepository entryDao){
        this.entryDao = entryDao;
        this.locationDao = locationDao;
    }




    @GetMapping(path = "/location-navigation/api/locations")
    @ResponseBody
    public List<Location> getAllLocations(){
        List<Entry> allEntries = entryDao.findAll();
        List<Long> idsOfLocations = new ArrayList<>();
        List<Location> relavantLocations = new ArrayList<>();
        for(int i = 0; i < allEntries.size(); i++){
            if(!idsOfLocations.contains(allEntries.get(i).getLocation().getId())){
                idsOfLocations.add(allEntries.get(i+1).getLocation().getId());
            }
        }
        for (int i = 0; i < idsOfLocations.size(); i++){
            relavantLocations.add(locationDao.getLocationById(idsOfLocations.get(i)));
        }
        return relavantLocations;
    }

    @GetMapping(path = "/location-navigation")
    public String locationNavigation(){
        return "location_navigation";
    }
}
