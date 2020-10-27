package com.nam.service;

import com.nam.data.model.Recipe;

import java.util.List;

public interface RecipeService {

    Recipe getRecipeId(Long recipeId);

    Recipe addRecipe(String name, String surName, String email, String password);

    List<Recipe> getRecipes(Long userId);
}
