package com.casper.coolwebsite.service.impl;

import com.casper.coolwebsite.dao.ArticleDao;
import com.casper.coolwebsite.dto.ArticleRequest;
import com.casper.coolwebsite.dto.WebsiteQueryParams;
import com.casper.coolwebsite.model.Article;
import com.casper.coolwebsite.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private ArticleDao articleDao;

    @Override
    public List<Article> getArticles(WebsiteQueryParams websiteQueryParams) {
        return articleDao.getArticles(websiteQueryParams);
    }

    @Override
    public Article getArticleId(Integer articleId) {
        return articleDao.getArticleId(articleId);
    }

    @Override
    public Integer createdArticle(ArticleRequest articleRequest) {
        return articleDao.createdArticle(articleRequest);
    }

    @Override
    public void updateArticle(Integer articleId, ArticleRequest articleRequest) {
        articleDao.updateArticle(articleId , articleRequest);
    }

    @Override
    public void deleteArticleById(Integer articleId) {
        articleDao.deleteArticleById(articleId);
    }


}
