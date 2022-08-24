package com.casper.coolwebsite.service.impl;

import com.casper.coolwebsite.dao.CategoryDao;
import com.casper.coolwebsite.dto.CategoryRequest;
import com.casper.coolwebsite.model.Category;
import com.casper.coolwebsite.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Category getCategoryById(Integer categoryId) {
        return categoryDao.getCategoryById(categoryId);
    }

    @Override
    public Integer createCategory(CategoryRequest categoryRequest) {
        return categoryDao.createCategory(categoryRequest);
    }
}
