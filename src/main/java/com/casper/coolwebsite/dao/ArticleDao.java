package com.casper.coolwebsite.dao;

import com.casper.coolwebsite.dto.ArticleRequest;
import com.casper.coolwebsite.dto.WebsiteQueryParams;
import com.casper.coolwebsite.model.Article;
import com.casper.coolwebsite.model.Category;
import com.casper.coolwebsite.model.Topic;

import java.util.List;

public interface ArticleDao {
    List<Article> getArticles(WebsiteQueryParams websiteQueryParams);
    Article getArticleId(Integer articleId);
    Integer createdArticle(ArticleRequest articleRequest);
    void updateArticle(Integer articleId, ArticleRequest articleRequest);
    void deleteArticleById(Integer articleId);
    Integer countArticle(WebsiteQueryParams websiteQueryParams);
}

