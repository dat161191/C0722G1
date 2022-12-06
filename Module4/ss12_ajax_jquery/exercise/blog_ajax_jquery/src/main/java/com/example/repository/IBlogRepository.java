package com.example.repository;


import com.example.model.Blog;
import com.example.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findByAuthorContaining(Pageable pageable,String author);
    Page<Blog> findByCategory(Pageable pageable, Category category);
}
