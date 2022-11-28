package com.example.demo.service;


import com.example.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();

    Page<T> findByBlogNameContainingOrAuthorContainingOrderByAuthor(String name, Pageable pageable);

    Optional<T> findById(Integer id);

    void save(T t);

    void remove(Integer id);
}
