package com.casper.coolwebsite.dto;

public class WebsiteQueryParams {

   private String search;
   private String orderBy;
   private String sort;
   private Integer limit;
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
