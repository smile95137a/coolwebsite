package com.casper.coolwebsite.service;

import com.casper.coolwebsite.dto.CategoryRequest;
import com.casper.coolwebsite.model.Category;

public interface CategoryService {
    Category getCategoryById(Integer categoryId);
    Integer createCategory(CategoryRequest categoryRequest);
    void updateCategory(Integer categoryId, CategoryRequest categoryRequest);
    void deleteCategoryById(Integer categoryId);
}
