package com.nam.service;

import com.nam.data.model.Category;

import java.util.List;

public interface CategoryService {

    Category getCategoryById(Long categoryId);

    List<Category> getCategories();

}
