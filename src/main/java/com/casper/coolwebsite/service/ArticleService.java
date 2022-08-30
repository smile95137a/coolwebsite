package com.casper.coolwebsite.service;

import com.casper.coolwebsite.dto.ArticleRequest;
import com.casper.coolwebsite.dto.WebsiteQueryParams;
import com.casper.coolwebsite.model.Article;

import java.util.List;

public interface ArticleService {
    List<Article> getArticles(WebsiteQueryParams websiteQueryParams);
    Article getArticleId(Integer articleId);
    Integer createdArticle(ArticleRequest articleRequest);
    void updateArticle(Integer articleId, ArticleRequest articleRequest);
    void deleteArticleById(Integer articleId);
}
