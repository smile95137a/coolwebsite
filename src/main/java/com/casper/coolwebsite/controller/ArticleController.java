package com.casper.coolwebsite.controller;

import com.casper.coolwebsite.dto.ArticleRequest;
import com.casper.coolwebsite.dto.WebsiteQueryParams;
import com.casper.coolwebsite.model.Article;
import com.casper.coolwebsite.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;
@Validated
@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/articles")
    public ResponseEntity<List<Article>> getArticles(
            //查詢條件
            @RequestParam(required = false) String search,
            //排序
            @RequestParam(defaultValue = "created_date") String orderBy,
            @RequestParam(defaultValue = "desc") String sort,
            //分頁
            @RequestParam(defaultValue = "5") @Max(1000) @Min(0) Integer limit,
            @RequestParam(defaultValue = "0") @Min(0) Integer offset
    ){
        WebsiteQueryParams websiteQueryParams = new WebsiteQueryParams();
        websiteQueryParams.setSearch(search);
        websiteQueryParams.setOrderBy(orderBy);
        websiteQueryParams.setSort(sort);
        websiteQueryParams.setLimit(limit);
        websiteQueryParams.setOffset(offset);

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
