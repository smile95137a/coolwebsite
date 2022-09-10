package com.casper.coolwebsite.dao;

import com.casper.coolwebsite.dto.CategoryRequest;
import com.casper.coolwebsite.model.Category;

import java.util.List;

public interface CategoryDao {
    Category getCategoryById(Integer categoryId);
    Integer createCategory(CategoryRequest categoryRequest);
    void updateCategory(Integer categoryId, CategoryRequest categoryRequest);
    void deleteCategoryById(Integer categoryId);
    List<Category> getCategory();
}
