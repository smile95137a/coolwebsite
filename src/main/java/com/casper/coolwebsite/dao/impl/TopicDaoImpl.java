package com.casper.coolwebsite.dao.impl;

import com.casper.coolwebsite.dao.TopicDao;
import com.casper.coolwebsite.dto.TopicRequest;
import com.casper.coolwebsite.model.Topic;
import com.casper.coolwebsite.rowmapper.TopicRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TopicDaoImpl implements TopicDao{

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    @Override
    public Topic getTopicById(Integer topicId) {
        String sql = "SELECT topic_id , category_id , topic_name , description FROM topic WHERE topic_id = :topicId";

        Map<String, Object> map = new HashMap<>();
        map.put("topicId", topicId);


        List<Topic> topicList = namedParameterJdbcTemplate.query(sql, map, new TopicRowMapper());

        if(topicList.size() > 0){
            return topicList.get(0);
        }else{
            return null;
        }

    }

    @Override
    public Integer createdTopic(TopicRequest topicRequest) {
        String sql = "INSERT INTO topic(category_id , topic_name , description , created_date , last_modified_date) "+
                "VALUES(:categoryId , :topicName , :description , :createdDate , :lastModifiedDate)";

        Map<String , Object> map = new HashMap<>();
        map.put("categoryId" , topicRequest.getCategoryId());
        map.put("topicName" , topicRequest.getTopicName());
        map.put("description" , topicRequest.getDescription());

        Date now = new Date();
        map.put("createdDate" , now);
        map.put("lastModifiedDate" , now);

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map) , keyHolder);

        int topicId = keyHolder.getKey().intValue();

        return topicId;
    }

    @Override
    public void updateTopic(Integer topicId, TopicRequest topicRequest) {
        String sql = "UPDATE topic SET category_id = :categoryId , topic_name = :topicName , description = :description , last_modified_date = :lastModifiedDate WHERE topic_id = :topicId";

        Map<String , Object> map = new HashMap<>();
        map.put("categoryId" , topicRequest.getCategoryId());
        map.put("topicName" , topicRequest.getTopicName());
        map.put("description" , topicRequest.getDescription());
        map.put("lastModifiedDate" , new Date());
        map.put("topicId" , topicId);

        namedParameterJdbcTemplate.update(sql , map);
    }

    @Override
    public void deleteTopicById(Integer topicId) {
        String sql = "DELETE FROM topic WHERE topic_id = :topicId";

        Map<String , Object> map = new HashMap<>();
        map.put("topicId" , topicId);

        namedParameterJdbcTemplate.update(sql , map);
    }
}
