package com.nam.service;

import com.nam.data.model.Ingredient;

import java.util.List;

public interface IngredientService {

    List<Ingredient> getAllIngredients();

    List<Ingredient> getIngredientsByIds(List<Long> ingredients);

}
