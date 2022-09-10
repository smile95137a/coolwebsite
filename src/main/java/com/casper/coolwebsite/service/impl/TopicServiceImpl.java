package com.casper.coolwebsite.service.impl;

import com.casper.coolwebsite.dao.TopicDao;
import com.casper.coolwebsite.dto.TopicRequest;
import com.casper.coolwebsite.model.Topic;
import com.casper.coolwebsite.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TopicServiceImpl implements TopicService{

    @Autowired
    private TopicDao topicDao;


    @Override
    public Topic getTopicById(Integer topicId) {
        return topicDao.getTopicById(topicId);
    }

    @Override
    public Integer createdTopic(TopicRequest topicRequest) {
        return topicDao.createdTopic(topicRequest);
    }

    @Override
    public void updateTopic(Integer topicId, TopicRequest topicRequest) {
        topicDao.updateTopic(topicId , topicRequest);
    }

    @Override
    public void deleteTopicById(Integer topicId) {
        topicDao.deleteTopicById(topicId);
    }

    @Override
    public List<Topic> getTopics() {
        return topicDao.getTopics();
    }

}
