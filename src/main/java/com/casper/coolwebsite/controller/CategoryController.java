package com.casper.coolwebsite.controller;

import com.casper.coolwebsite.dto.CategoryRequest;
import com.casper.coolwebsite.model.Category;
import com.casper.coolwebsite.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Integer categoryId){
        Category category = categoryService.getCategoryById(categoryId);

        if(category != null){
            return ResponseEntity.status(HttpStatus.OK).body(category);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/category")
    public ResponseEntity<Category> createCategory(@RequestBody @Valid CategoryRequest categoryRequest){
        //新增一個類別回傳值為類別ID，再利用ID去查詢類別丟還給前端。
        Integer categoryId = categoryService.createCategory(categoryRequest);

        Category category = categoryService.getCategoryById(categoryId);

        return ResponseEntity.status(HttpStatus.CREATED).body(category);
    }
}
