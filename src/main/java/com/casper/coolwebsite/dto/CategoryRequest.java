package com.casper.coolwebsite.dto;

import com.sun.istack.internal.NotNull;

import java.util.Date;

public class CategoryRequest {
    @NotNull
    private String categoryName;
    private String description;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
