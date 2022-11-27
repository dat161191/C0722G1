package com.example.app_blog_modal.repository;

import com.example.app_blog_modal.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findByBlogNameOrAuthorContaining(String blogName, String author);
}
