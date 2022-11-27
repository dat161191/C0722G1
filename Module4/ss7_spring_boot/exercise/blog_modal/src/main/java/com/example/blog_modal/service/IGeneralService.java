package com.example.blog_modal.service;



import com.example.blog_modal.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();

    List<Blog> findByBlogNameContainingOrAuthorContaining(String name);

    Optional<T> findById(Integer id);

    void save(T t);

    void remove(Integer id);
}
