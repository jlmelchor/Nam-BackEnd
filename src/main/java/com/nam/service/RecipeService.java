package com.nam.service;

import com.nam.data.model.Recipe;

import java.util.List;

public interface RecipeService {

    Recipe getRecipeId(Long recipeId);

    Recipe addRecipe(String name, List<String> ingredients, String description, Long categoryId, Long userId);

    List<Recipe> getRecipes(Long userId);

    List<Recipe> getRecipesFiltered(List<String> ingredients);
}
