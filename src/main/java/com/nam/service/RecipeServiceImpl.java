package com.nam.service;

import com.nam.data.model.Ingredient;
import com.nam.data.model.Recipe;
import com.nam.data.model.RecipeFav;
import com.nam.data.model.RecipeIngredient;
import com.nam.data.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    RecipeIngredientService recipeIngredientService;

    @Autowired
    IngredientService ingredientService;

    @Autowired
    RecipeFavService recipeFavService;

    @Override
    public Recipe getRecipeId(Long recipeId) {
        return recipeRepository.getOne(recipeId);
    }

    @Override
    public Recipe addRecipe(String name, String surName, String email, String password) {
        Recipe recipe = new Recipe();
        return recipe;
    }

    @Override
    public List<Recipe> getRecipes(Long userId) {
        List<Recipe> recipes = recipeRepository.findAll();
        // Recetas favoritas del usuario
        List<RecipeFav> recipeFavs = recipeFavService.getRecipeFavs(userId);
        for (Recipe recipe : recipes) {
            List<Long> ingredientsId = new ArrayList<>();
            // Ingredientes de cada receta
            List<RecipeIngredient> recipeIngredients = recipeIngredientService.getByRecipe(recipe.getRecipeId());
            for (RecipeIngredient recipeIngredient : recipeIngredients) {
                ingredientsId.add(recipeIngredient.getIngredient().getIngredientId());
            }
            List<Ingredient> ingredients = ingredientService.getIngredientsByIds(ingredientsId);
            if (ingredients != null) {
                recipe.setIngredients(ingredients);
            }
            // Comprobamos si la receta está guardada como favorita para ese usuario
            if (recipeFavs != null & recipeFavs.size() > 0) {
                for (RecipeFav recipeFav : recipeFavs) {
                    if (recipeFav.getRecipe().getRecipeId() == recipe.getRecipeId()) {
                        recipe.setIsFav("Y");
                    }
                }
            } else {
                recipe.setIsFav("N");
            }
        }
        return recipes;
    }

    @Override
    public List<Recipe> getRecipesFiltered(List<String> userIngredientList) {
        List<Recipe> recipes = recipeRepository.findAll();
        List<Recipe> recipesResult = new ArrayList<>();
        for (Recipe recipe : recipes) {
            List<Long> ingredientsId = new ArrayList<>();
            List<String> ingredientsList = new ArrayList<>();
            // Ingredientes de cada receta
            List<RecipeIngredient> recipeIngredients = recipeIngredientService.getByRecipe(recipe.getRecipeId());
            for (RecipeIngredient recipeIngredient : recipeIngredients) {
                ingredientsId.add(recipeIngredient.getIngredient().getIngredientId());
            }
            List<Ingredient> ingredients = ingredientService.getIngredientsByIds(ingredientsId);
            if (ingredients != null) {
                recipe.setIngredients(ingredients);
                for (Ingredient ing : ingredients) {
                    ingredientsList.add(ing.getName());
                }
                if (ingredientsList.containsAll(userIngredientList)) {
                    recipesResult.add(recipe);
                }
            }
        }
        return recipesResult;
    }
}
