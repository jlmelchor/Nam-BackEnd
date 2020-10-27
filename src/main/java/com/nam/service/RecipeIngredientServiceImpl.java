package com.nam.service;

import com.nam.data.model.RecipeIngredient;
import com.nam.data.repository.RecipeIngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeIngredientServiceImpl implements RecipeIngredientService {

    @Autowired
    RecipeIngredientRepository recipeIngredientRepository;

    @Autowired
    RecipeService recipeService;

    @Override
    public List<RecipeIngredient> getByRecipe(Long recipeId) {
        List<RecipeIngredient> recipeIngredients = recipeIngredientRepository.findByRecipe(recipeService.getRecipeId(recipeId));
        return recipeIngredients;
    }
}
