package com.casper.coolwebsite.service;

import com.casper.coolwebsite.dto.ArticleRequest;
import com.casper.coolwebsite.model.Article;

public interface ArticleService {
    Article getArticleId(Integer articleId);

    Integer createdArticle(ArticleRequest articleRequest);
}
