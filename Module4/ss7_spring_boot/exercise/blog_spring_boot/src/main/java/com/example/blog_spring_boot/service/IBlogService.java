package com.example.blog_spring_boot.service;

import com.example.blog_spring_boot.model.Blog;

import java.util.List;

public interface IBlogService extends IGeneralService<Blog>{
    List<Blog> findByAuthorContainingOrContentContainingOrTitleContaining(String name);

}