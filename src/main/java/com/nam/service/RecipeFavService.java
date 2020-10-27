package com.nam.service;

import com.nam.data.model.Recipe;
import com.nam.data.model.RecipeFav;

import java.util.List;

public interface RecipeFavService {

    List<RecipeFav> getRecipeFavs(Long userId);

    Recipe addRecipeFav(Long userId, Long recipeId);

    Recipe deleteRecipeFav(Long userId, Long recipeId);

}
