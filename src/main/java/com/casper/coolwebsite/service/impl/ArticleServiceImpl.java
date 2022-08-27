package com.casper.coolwebsite.service.impl;

import com.casper.coolwebsite.dao.ArticleDao;
import com.casper.coolwebsite.dto.ArticleRequest;
import com.casper.coolwebsite.model.Article;
import com.casper.coolwebsite.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private ArticleDao articleDao;

    @Override
    public Article getArticleId(Integer articleId) {
        return articleDao.getArticleId(articleId);
    }

    @Override
    public Integer createdArticle(ArticleRequest articleRequest) {
        return articleDao.createdArticle(articleRequest);
    }
}
