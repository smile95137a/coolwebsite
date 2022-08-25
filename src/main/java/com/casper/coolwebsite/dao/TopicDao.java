package com.casper.coolwebsite.dao;

import com.casper.coolwebsite.dto.TopicRequest;
import com.casper.coolwebsite.model.Topic;

public interface TopicDao {

    Topic getTopicById(Integer topicId);

    Integer createdTopic(TopicRequest topicRequest);
}
