package com.nam.controller;

import com.nam.data.model.Recipe;
import com.nam.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class RecipeController {

    @Autowired
    RecipeService recipeService;

    // Añade una receta
    @RequestMapping(value = "/recipe", method = RequestMethod.POST)
    public Recipe addRecipe(
            @RequestParam("name") String name,
            @RequestParam("surname") String surname,
            @RequestParam("email") String email,
            @RequestParam("password") String password
            ) {
        Recipe recipe = recipeService.addRecipe(name, surname, email, password);
        return recipe;
    }

    // Devuelve todas las recetas (y si son favoritas para cada usuario)
    @RequestMapping(value = "/recipes/{userId}", method = RequestMethod.GET)
    public List<Recipe> getRecipes(
            @PathVariable("userId") Long userId
            ) {
        List<Recipe> recipes = recipeService.getRecipes(userId);
        return recipes;
    }
}
