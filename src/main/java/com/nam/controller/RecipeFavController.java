package com.nam.controller;

import com.nam.data.model.Recipe;
import com.nam.service.RecipeFavService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class RecipeFavController {

    @Autowired
    RecipeFavService recipeFavService;

    // Añade una receta favorita a un usuario
    @RequestMapping(value = "/addFav", method = RequestMethod.POST)
    public Recipe addRecipeFav(
            @RequestParam("userId") Long userId,
            @RequestParam("recipeId") Long recipeId
            ) {
        Recipe recipe = recipeFavService.addRecipeFav(userId, recipeId);
        return recipe;
    }

    // Elimina una receta favorita de un usuario
    @RequestMapping(value = "/quitFav", method = RequestMethod.POST)
    public Recipe deleteRecipeFav(
            @RequestParam("userId") Long userId,
            @RequestParam("recipeId") Long recipeId
            ) {
        Recipe recipe = recipeFavService.deleteRecipeFav(userId, recipeId);
        return recipe;
    }
}
