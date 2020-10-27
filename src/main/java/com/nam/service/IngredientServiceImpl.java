package com.nam.service;

import com.nam.data.model.Ingredient;
import com.nam.data.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    IngredientRepository ingredientRepository;

    @Override
    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    @Override
    public List<Ingredient> getIngredientsByIds(List<Long> ingredients) { return ingredientRepository.findAllById(ingredients); }
}
