package com.example.service;


import com.example.model.Blog;
import com.example.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService{
    List<Blog> findAll();
    Blog findById(Integer id);

    void save(Blog blog);

    Page<Blog> findAll(Pageable pageable,String search);

    void remove(Integer id);

    Page<Blog> findByCategoryContains(Pageable pageable, Category category);
}
