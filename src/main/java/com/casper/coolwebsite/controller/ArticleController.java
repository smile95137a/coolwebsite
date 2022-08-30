package com.casper.coolwebsite.controller;

import com.casper.coolwebsite.dto.ArticleRequest;
import com.casper.coolwebsite.dto.CategoryRequest;
import com.casper.coolwebsite.dto.WebsiteQueryParams;
import com.casper.coolwebsite.model.Article;
import com.casper.coolwebsite.model.Category;
import com.casper.coolwebsite.model.Topic;
import com.casper.coolwebsite.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/articles")
    public ResponseEntity<List<Article>> getArticles(
            @RequestParam(required = false) String search
    ){
        WebsiteQueryParams websiteQueryParams = new WebsiteQueryParams();
        websiteQueryParams.setSearch(search);

        List<Article> articleList = articleService.getArticles(websiteQueryParams);

        return ResponseEntity.status(HttpStatus.OK).body(articleList);
    }


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

    @PutMapping("/article/{articleId}")
    public ResponseEntity<Article> updateCategory(@PathVariable Integer articleId,
                                                   @RequestBody @Valid  ArticleRequest articleRequest){

        //檢查category是否存在
        Article article = articleService.getArticleId(articleId);

        if(article == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        //修改category的數據
        articleService.updateArticle(articleId , articleRequest);

        Article updateArticle = articleService.getArticleId(articleId);

        return ResponseEntity.status(HttpStatus.OK).body(updateArticle);
    }

    @DeleteMapping("/article/{articleId}")
    public ResponseEntity<?> deleteArticle(@PathVariable Integer articleId){
        articleService.deleteArticleById(articleId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
