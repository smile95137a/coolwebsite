package com.casper.coolwebsite.controller;

import com.casper.coolwebsite.dto.TopicRequest;
import com.casper.coolwebsite.model.Category;
import com.casper.coolwebsite.model.Topic;
import com.casper.coolwebsite.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping("/topic/{topicId}")
    public ResponseEntity<Topic> getTopicById(@PathVariable Integer topicId){
       Topic topic = topicService.getTopicById(topicId);

        if(topic != null){
            return ResponseEntity.status(HttpStatus.OK).body(topic);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/topic")
    public ResponseEntity<Topic> createdTopic(@RequestBody @Valid TopicRequest topicRequest){
        Integer topicId = topicService.createdTopic(topicRequest);

        Topic topic = topicService.getTopicById(topicId);

        return ResponseEntity.status(HttpStatus.CREATED).body(topic);
    }

}
