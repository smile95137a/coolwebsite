package com.casper.coolwebsite.controller;

import com.casper.coolwebsite.dto.ArticleRequest;
import com.casper.coolwebsite.model.Article;
import com.casper.coolwebsite.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/article/{articleId}")
    public ResponseEntity<Article> getArticleId(@PathVariable Integer articleId){
        Article article = articleService.getArticleId(articleId);

        if(article != null){
            return ResponseEntity.status(HttpStatus.OK).body(article);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/article")
    public ResponseEntity<Article> createdArticle(@RequestBody @Valid ArticleRequest articleRequest){
        Integer articleId = articleService.createdArticle(articleRequest);

        Article article = articleService.getArticleId(articleId);

        return ResponseEntity.status(HttpStatus.CREATED).body(article);
    }
}
