package com.example.blog_modal.repository;


import com.example.blog_modal.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findByBlogNameContainingOrAuthorContaining(String blogName, String author);
}
