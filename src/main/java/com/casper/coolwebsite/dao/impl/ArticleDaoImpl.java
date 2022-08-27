package com.casper.coolwebsite.dao.impl;

import com.casper.coolwebsite.dao.ArticleDao;
import com.casper.coolwebsite.dto.ArticleRequest;
import com.casper.coolwebsite.model.Article;
import com.casper.coolwebsite.rowmapper.ArticleRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ArticleDaoImpl implements ArticleDao{

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Article getArticleId(Integer articleId) {
        String sql = "SELECT article_id , topic_id , article_title , article_text , article_author , article_image_url , created_date , last_modified_date FROM article WHERE article_id = :articleId";

        Map<String , Object> map = new HashMap<>();
        map.put("articleId" , articleId);

        List<Article> articleList = namedParameterJdbcTemplate.query(sql , map , new ArticleRowMapper());

        if(articleList.size() > 0){
            return articleList.get(0);
        }else{
            return null;
        }

    }

    @Override
    public Integer createdArticle(ArticleRequest articleRequest) {
        String sql = "INSERT INTO  article(topic_id , article_title , article_text , article_author , article_image_url , created_date , last_modified_date) "
                +"VALUES(:topicId , :articleTitle , :articleText , :articleAuthor , :articleImageUrl , :createdDate , :lastModifiedDate)";
        System.out.println(articleRequest.getArticleTitle());
        Map<String , Object> map = new HashMap<>();
        map.put("topicId" , articleRequest.getTopicId());
        map.put("articleTitle" , articleRequest.getArticleTitle());
        map.put("articleText" , articleRequest.getArticleText());
        map.put("articleAuthor" , articleRequest.getArticleAuthor());
        map.put("articleImageUrl" , articleRequest.getImageUrl());

        Date now = new Date();
        map.put("createdDate" , now);
        map.put("lastModifiedDate" , now);
        System.out.println(map.get("articleTitle"));
        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql , new MapSqlParameterSource(map), keyHolder);

        int articleId = keyHolder.getKey().intValue();
        return articleId;
    }
}
