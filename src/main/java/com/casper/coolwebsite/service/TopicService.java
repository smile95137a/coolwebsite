package com.casper.coolwebsite.service;

import com.casper.coolwebsite.dto.TopicRequest;
import com.casper.coolwebsite.model.Topic;

public interface TopicService {

    Topic getTopicById(Integer topicId);
    Integer createdTopic(TopicRequest topicRequest);


}
