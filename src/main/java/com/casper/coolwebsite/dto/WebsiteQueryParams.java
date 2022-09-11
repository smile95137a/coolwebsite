package com.casper.coolwebsite.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "文章頁面所需參數，例如:查詢條件、順序...等")
public class WebsiteQueryParams {
   @ApiModelProperty("文章名稱查詢")
   private String search;
   @ApiModelProperty("文章順序")
   private String orderBy;
   @ApiModelProperty("文章排序")
   private String sort;
   @ApiModelProperty("文章顯示最大數")
   private Integer limit;
   @ApiModelProperty("略過幾篇文章")
   private Integer offset;

   public Integer getLimit() {
      return limit;
   }

   public void setLimit(Integer limit) {
      this.limit = limit;
   }

   public Integer getOffset() {
      return offset;
   }

   public void setOffset(Integer offset) {
      this.offset = offset;
   }

   public String getOrderBy() {
      return orderBy;
   }

   public void setOrderBy(String orderBy) {
      this.orderBy = orderBy;
   }

   public String getSort() {
      return sort;
   }

   public void setSort(String sort) {
      this.sort = sort;
   }

   public String getSearch() {
      return search;
   }

   public void setSearch(String search) {
      this.search = search;
   }
}
