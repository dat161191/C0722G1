package com.example.blog_spring_boot.service.impl;

import com.example.blog_spring_boot.model.Blog;
import com.example.blog_spring_boot.repository.IBlogRepository;
import com.example.blog_spring_boot.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public Iterable<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Optional<Blog> findById(int id) {
        return blogRepository.findById(id);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(int id) {
        blogRepository.deleteById(id);
    }

    @Override
    public List<Blog> findByAuthorContainingOrContentContainingOrTitleContaining(String name) {
        return blogRepository.findByAuthorContainingOrContentContainingOrTitleContaining(name, name, name);
    }
}
