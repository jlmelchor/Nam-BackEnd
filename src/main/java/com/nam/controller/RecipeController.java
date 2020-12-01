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

    // Añade una receta para un usuario
    @RequestMapping(value = "/recipe", method = RequestMethod.POST)
    public Recipe addRecipe(
            @RequestParam("name") String name,
            @RequestParam("ingredients") List<String> ingredients,
            @RequestParam("description") String description,
            @RequestParam("category") Long categoryId,
            @RequestParam("userId") Long userId
            ) {
        Recipe recipe = recipeService.addRecipe(name, ingredients, description, categoryId, userId);
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

    // Devuelve el resultado del filtrado de recetas a partir de una lista de ingredientes
    @RequestMapping(value = "/recipesFiltered", method = RequestMethod.POST)
    public List<Recipe> filterRecipes(
            @RequestParam("foodList") List<String> ingredients
    ) {
        List<Recipe> recipes = recipeService.getRecipesFiltered(ingredients);
        return recipes;
    }
}
