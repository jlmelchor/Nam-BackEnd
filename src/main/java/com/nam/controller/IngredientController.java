package com.nam.controller;

import com.nam.data.model.Ingredient;
import com.nam.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IngredientController {

    @Autowired
    IngredientService ingredientService;

    @RequestMapping(value = "/ingredients", method = RequestMethod.GET)
    public List<Ingredient> getIngredients(){
        return ingredientService.getAllIngredients();
    }
}
