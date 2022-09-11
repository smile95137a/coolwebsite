package com.casper.coolwebsite.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
@ApiModel(description = "增修話題所需異動欄位")
public class TopicRequest {

    @NotNull
    @ApiModelProperty(value = "類別編號" , required = true)
    private Integer categoryId;
    @NotNull
    @ApiModelProperty(value = "文章名稱" , required = true)
    private String topicName;
    @ApiModelProperty(value = "話題描述")
    private String description;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
