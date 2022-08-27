package com.casper.coolwebsite.dao;

import com.casper.coolwebsite.dto.ArticleRequest;
import com.casper.coolwebsite.model.Article;

public interface ArticleDao {
    Article getArticleId(Integer articleId);

    Integer createdArticle(ArticleRequest articleRequest);
}
