package com.casper.coolwebsite.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
@ApiModel(description = "話題")
public class Topic {
    @ApiModelProperty("話題編號")
    private Integer topicId;
    @ApiModelProperty("類別編號")
    private Integer categoryId;
    @ApiModelProperty("話題名稱")
    private String topicName;
    @ApiModelProperty("描述")
    private String description;
    @ApiModelProperty("創建時間")
    private Date createdDate;
    @ApiModelProperty("修改時間")
    private Date lastModifiedDate;

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
