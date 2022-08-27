package com.casper.coolwebsite.rowmapper;

import com.casper.coolwebsite.model.Article;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ArticleRowMapper implements RowMapper{
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Article article = new Article();
        article.setArticleId(resultSet.getInt("article_id"));
        article.setTopicId(resultSet.getInt("topic_id"));
        article.setArticleTitle(resultSet.getString("article_title"));
        article.setArticleText(resultSet.getString("article_text"));
        article.setArticleAuthor(resultSet.getString("article_author"));
        article.setArticleImageUrl(resultSet.getString("article_image_url"));
        article.setCreatedDate(resultSet.getTimestamp("created_date"));
        article.setLastModifiedDate(resultSet.getTimestamp("last_modified_date"));

        return article;
    }
}
