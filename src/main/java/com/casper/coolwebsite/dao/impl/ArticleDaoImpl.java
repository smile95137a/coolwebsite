package com.casper.coolwebsite.dao.impl;

import com.casper.coolwebsite.dao.ArticleDao;
import com.casper.coolwebsite.dto.ArticleRequest;
import com.casper.coolwebsite.dto.WebsiteQueryParams;
import com.casper.coolwebsite.model.Article;
import com.casper.coolwebsite.model.Category;
import com.casper.coolwebsite.model.Topic;
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
    public List<Article> getArticles(WebsiteQueryParams websiteQueryParams) {
        String sql = "SELECT article_id , topic_id , article_title , article_text , article_author , article_image_url , created_date , last_modified_date FROM article" +
                      " WHERE 1=1";

        Map<String , Object> map = new HashMap<>();
        //查詢條件
        if(websiteQueryParams.getSearch() != null){
            sql = sql + " AND article_title like :search";
            map.put("search" , "%" +websiteQueryParams.getSearch() + "%");
        }
        //排序
        sql = sql + " ORDER BY " + websiteQueryParams.getOrderBy() + " " + websiteQueryParams.getSort();

        //分頁
        sql = sql + " LIMIT :limit OFFSET :offset";
        map.put("limit" , websiteQueryParams.getLimit());
        map.put("offset" , websiteQueryParams.getOffset());

        List<Article> articleList = namedParameterJdbcTemplate.query(sql , map , new ArticleRowMapper());

        return articleList;
    }

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
        map.put("articleImageUrl" , articleRequest.getArticleImageUrl());

        Date now = new Date();
        map.put("createdDate" , now);
        map.put("lastModifiedDate" , now);
        System.out.println(map.get("articleTitle"));
        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql , new MapSqlParameterSource(map), keyHolder);

        int articleId = keyHolder.getKey().intValue();
        return articleId;
    }

    @Override
    public void updateArticle(Integer articleId, ArticleRequest articleRequest) {
        String sql = "UPDATE article SET topic_id = :topicId , article_title = :articleTitle , article_text = :articleText , article_author = :articleAuthor , article_image_url = :articleImageUrl , last_modified_date = :lastModifiedDate WHERE article_id = :articleId";

        Map<String , Object> map = new HashMap<>();
        map.put("topicId" , articleRequest.getTopicId());
        map.put("articleTitle" , articleRequest.getArticleTitle());
        map.put("articleText" , articleRequest.getArticleText());
        map.put("articleAuthor" , articleRequest.getArticleAuthor());
        map.put("articleImageUrl" , articleRequest.getArticleImageUrl());
        map.put("lastModifiedDate" , new Date());
        map.put("articleId" , articleId);

        namedParameterJdbcTemplate.update(sql , map);
    }

    @Override
    public void deleteArticleById(Integer articleId) {
        String sql = "DELETE FROM article WHERE article_id = :articleId";

        Map<String , Object> map = new HashMap<>();
        map.put("articleId" , articleId);

        namedParameterJdbcTemplate.update(sql , map);
    }
}
