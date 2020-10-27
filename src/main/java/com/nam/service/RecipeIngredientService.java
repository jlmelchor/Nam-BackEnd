package com.nam.service;

import com.nam.data.model.RecipeIngredient;

import java.util.List;

public interface RecipeIngredientService {

    List<RecipeIngredient> getByRecipe(Long recipeId);
}
