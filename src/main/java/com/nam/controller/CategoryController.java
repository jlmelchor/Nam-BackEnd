package com.nam.controller;

import com.nam.data.model.Category;
import com.nam.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public List<Category> getCategories(){
        return categoryService.getCategories();
    }
}
