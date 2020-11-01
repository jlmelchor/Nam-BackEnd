package com.nam.controller;

import com.nam.data.model.Family;
import com.nam.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class FamilyController {

    @Autowired
    FamilyService familyService;

    @RequestMapping(value = "/families", method = RequestMethod.GET)
    public List<Family> getIngredients(){
        return familyService.getAllFamilies();
    }
}
