package com.contagionwatch.contagionwatch.controllers;

import com.contagionwatch.contagionwatch.dao.EntryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DeleteController {
    private final EntryRepository entryDao;

    public DeleteController(EntryRepository entryDao) {
        this.entryDao = entryDao;
    }

    @RequestMapping(path = "/delete", method = RequestMethod.POST)
    public String deleteEntry(@RequestParam (name = "deleteId") long delete, @RequestParam(name = "whichDiseaseDelete") long id){
        entryDao.deleteById(delete);
        return "redirect:/information/" + id;
    }

    @RequestMapping(path = "/deleteL", method = RequestMethod.POST)
    public String deleteLEntry(@RequestParam (name = "deleteId") long delete, @RequestParam(name = "whichLocationDelete") long id){
        entryDao.deleteById(delete);
        return "redirect:/location/" + id;
    }

}
