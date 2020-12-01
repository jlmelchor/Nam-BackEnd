package com.nam.service;

import com.nam.data.model.Category;
import com.nam.data.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category getCategoryById(Long categoryId) { return categoryRepository.getOne(categoryId); }

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

}
