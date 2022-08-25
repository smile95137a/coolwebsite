package com.casper.coolwebsite.rowmapper;

import com.casper.coolwebsite.model.Topic;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TopicRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Topic topic = new Topic();

        topic.setTopicId(resultSet.getInt("topic_id"));
        topic.setCategoryId(resultSet.getInt("category_id"));
        topic.setTopicName(resultSet.getString("topic_name"));
        topic.setDescription(resultSet.getString("description"));

        return topic;
    }
}
