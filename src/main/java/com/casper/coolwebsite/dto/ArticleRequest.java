package com.casper.coolwebsite.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Date;
@ApiModel(description = "增修文章所需異動欄位")
public class ArticleRequest {
    @NotNull
    @ApiModelProperty(value = "文章編號" , required = true)
    private Integer topicId;
    @NotNull
    @ApiModelProperty(value = "標題" , required = true)
    private String articleTitle;
    @NotNull
    @ApiModelProperty(value = "內容" , required = true)
    private String articleText;
    @NotNull
    @ApiModelProperty(value = "作者" , required = true)
    private String articleAuthor;
    @ApiModelProperty(value = "圖片連結")
    private String articleImageUrl;

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleText() {
        return articleText;
    }

    public void setArticleText(String articleText) {
        this.articleText = articleText;
    }

    public String getArticleAuthor() {
        return articleAuthor;
    }

    public void setArticleAuthor(String articleAuthor) {
        this.articleAuthor = articleAuthor;
    }

    public String getArticleImageUrl() {
        return articleImageUrl;
    }

    public void setArticleImageUrl(String articleImageUrl) {
        this.articleImageUrl = articleImageUrl;
    }
}
