package com.casper.coolwebsite.dao.impl;

import com.casper.coolwebsite.dao.CategoryDao;
import com.casper.coolwebsite.dto.CategoryRequest;
import com.casper.coolwebsite.model.Category;
import com.casper.coolwebsite.rowmapper.CategoryRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CategoryDaoImpl implements CategoryDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    @Override
    public Category getCategoryById(Integer categoryId) {
        String sql = "SELECT category_id , category_name FROM category WHERE category_id = :categoryId";

        Map<String , Object> map = new HashMap<>();

        map.put("categoryId" , categoryId);

        List<Category> categoryList = namedParameterJdbcTemplate.query(sql , map , new CategoryRowMapper());

        if(categoryList.size() > 0){
            return categoryList.get(0);
        }else{
            return null;
        }
    }

    @Override
    public Integer createCategory(CategoryRequest categoryRequest) {
        String sql ="INSERT INTO category(category_name , description , created_date , last_modified_date) "+
                "VALUES(:categoryName , :description , :createdDate , :lastModifiedDate)";

        Map<String , Object> map = new HashMap<>();

        map.put("categoryName" , categoryRequest.getCategoryName());
        map.put("description" , categoryRequest.getDescription());

        Date now = new Date();
        map.put("createdDate" , now);
        map.put("lastModifiedDate" , now);

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql , new MapSqlParameterSource(map) , keyHolder);

        int categoryId = keyHolder.getKey().intValue();
        return categoryId;
    }
}
