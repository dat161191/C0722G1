package com.example.blog_spring_boot.repository;

import com.example.blog_spring_boot.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findByAuthorContainingOrContentContainingOrTitleContaining(String author, String content, String title);
}
