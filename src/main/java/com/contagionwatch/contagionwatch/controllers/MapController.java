package com.contagionwatch.contagionwatch.controllers;

import com.contagionwatch.contagionwatch.dao.DiseaseRepository;
import com.contagionwatch.contagionwatch.dao.LocationRepository;
import com.contagionwatch.contagionwatch.models.Entry;
import com.contagionwatch.contagionwatch.models.Location;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


@Controller
public class MapController {

    @Value("${mapboxKey}")
    private String mapboxKey;

    private final DiseaseRepository diseaseDao;
    private final LocationRepository locationDao;

    public MapController(DiseaseRepository diseaseDao, LocationRepository locationDao){
        this.diseaseDao = diseaseDao;
        this.locationDao = locationDao;
    }

    @GetMapping(path = "/map/api/1")
    @ResponseBody
    public List<Entry> getMostRecentCoronaEntry(){
       List<Entry> CoronaDiseaseEntries = diseaseDao.getDiseaseById(1).getEntry();
        List<Location> locations = locationDao.findAll();
        List<Entry> recentEntriesCorona = new ArrayList<Entry>();
        Entry entryToAdd = null;
        for (Location location: locations){
            List<Entry> locationEntries = new ArrayList<Entry>();
            for (Entry entry: CoronaDiseaseEntries) {
                if(entry.getLocation().getId() == location.getId()){
                    locationEntries.add(entry);
                }
            }
            if(locationEntries.size() != 0){
                Entry entry1 = locationEntries.get(0);
                for (Entry entry: locationEntries){
                    if (entry.getDate().compareTo(entry1.getDate()) > 0){
                        entry1 = entry;
                    }


                }
                entryToAdd = entry1;

            }
            if(entryToAdd != null){
                recentEntriesCorona.add(entryToAdd);
            }
            entryToAdd = null;
        };

        return recentEntriesCorona;
    }

    @GetMapping(path = "/map/api/2")
    @ResponseBody
    public List<Entry> getEbolaEntries(){
        List<Entry> EbolaDiseaseEntries = diseaseDao.getDiseaseById(2).getEntry();
        List<Location> locations = locationDao.findAll();
        List<Entry> recentEntriesEbola = new ArrayList<Entry>();
        Entry entryToAdd = null;
        for (Location location: locations){
            List<Entry> locationEntries = new ArrayList<Entry>();
            for (Entry entry: EbolaDiseaseEntries) {
                if(entry.getLocation().getId() == location.getId()){
                    locationEntries.add(entry);
                }
            }
            if(locationEntries.size() != 0){
                Entry entry1 = locationEntries.get(0);
                for (Entry entry: locationEntries){
                    if (entry.getDate().compareTo(entry1.getDate()) > 0){
                        entry1 = entry;
                    }


                }
                entryToAdd = entry1;

            }
            if(entryToAdd != null){
                recentEntriesEbola.add(entryToAdd);
            }
            entryToAdd = null;
        };

        return recentEntriesEbola;
    }

    @GetMapping(path = "/map/api/3")
    @ResponseBody
    public List<Entry> getMalariaEntries(){
        List<Entry> MalariaDiseaseEntries = diseaseDao.getDiseaseById(3).getEntry();
        List<Location> locations = locationDao.findAll();
        List<Entry> recentEntriesMalaria = new ArrayList<Entry>();
        Entry entryToAdd = null;
        for (Location location: locations){
            List<Entry> locationEntries = new ArrayList<Entry>();
            for (Entry entry: MalariaDiseaseEntries) {
                if(entry.getLocation().getId() == location.getId()){
                    locationEntries.add(entry);
                }
            }
            if(locationEntries.size() != 0){
                Entry entry1 = locationEntries.get(0);
                for (Entry entry: locationEntries){
                    if (entry.getDate().compareTo(entry1.getDate()) > 0){
                        entry1 = entry;
                    }


                }
                entryToAdd = entry1;

            }
            if(entryToAdd != null){
                recentEntriesMalaria.add(entryToAdd);
            }
            entryToAdd = null;
        };

        return recentEntriesMalaria;
    }

    @GetMapping("/map")
    public String homePage(Model model){
        model.addAttribute("mapboxKey",mapboxKey);
        return "map";
    }


    public static void main(String[] args) {

    }


}
