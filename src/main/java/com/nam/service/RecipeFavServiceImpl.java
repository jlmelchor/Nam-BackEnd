package com.nam.service;

import com.nam.data.model.Recipe;
import com.nam.data.model.RecipeFav;
import com.nam.data.repository.RecipeFavRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeFavServiceImpl implements RecipeFavService {

    @Autowired
    RecipeFavRepository recipeFavRepository;

    @Autowired
    RecipeIngredientService recipeIngredientService;

    @Autowired
    IngredientService ingredientService;

    @Autowired
    UserService userService;

    @Autowired
    RecipeService recipeService;

    @Override
    public List<RecipeFav> getRecipeFavs(Long userId) {
        List<RecipeFav> recipeFavs = recipeFavRepository.findByNamUser(userService.getUser(userId));
        return recipeFavs;
    }

    @Override
    public Recipe addRecipeFav(Long userId, Long recipeId) {
        RecipeFav recipeFav = new RecipeFav();
        recipeFav.setUser(userService.getUser(userId));
        recipeFav.setRecipe(recipeService.getRecipeId(recipeId));
        recipeFavRepository.save(recipeFav);
        Recipe recipe = recipeService.getRecipeId(recipeId);
        recipe.setIsFav("Y");
        return recipe;
    }

    @Override
    public Recipe deleteRecipeFav(Long userId, Long recipeId) {
        RecipeFav recipeFav = recipeFavRepository.findByNamUserAndRecipe(userService.getUser(userId), recipeService.getRecipeId(recipeId));
        if (recipeFav != null) {
            recipeFavRepository.delete(recipeFav);
        }
        Recipe recipe = recipeService.getRecipeId(recipeId);
        recipe.setIsFav("N");
        return recipe;
    }
}
