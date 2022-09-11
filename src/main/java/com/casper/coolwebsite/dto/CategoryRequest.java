package com.casper.coolwebsite.dto;

import com.sun.istack.internal.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "增修類別所需異動欄位")
public class CategoryRequest {
    @NotNull
    @ApiModelProperty(value = "類別名稱" , required = true)
    private String categoryName;
    @ApiModelProperty("類別描述")
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
