package com.casper.coolwebsite.controller;

import com.casper.coolwebsite.model.Category;
import com.casper.coolwebsite.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;


}
