package com.casper.coolwebsite.dao;

import com.casper.coolwebsite.dto.CategoryRequest;
import com.casper.coolwebsite.model.Category;

public interface CategoryDao {
    Category getCategoryById(Integer categoryId);
    Integer createCategory(CategoryRequest categoryRequest);
}
