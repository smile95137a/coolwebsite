package com.casper.coolwebsite.dao;

import com.casper.coolwebsite.dto.TopicRequest;
import com.casper.coolwebsite.model.Topic;

public interface TopicDao {

    Topic getTopicById(Integer topicId);
    Integer createdTopic(TopicRequest topicRequest);
    void updateTopic(Integer topicId, TopicRequest topicRequest);
    void deleteTopicById(Integer topicId);
}
