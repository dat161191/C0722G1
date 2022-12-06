package com.example.service.impl;

import com.example.model.Blog;
import com.example.model.Category;
import com.example.repository.IBlogRepository;
import com.example.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    private IBlogRepository iBlogRepository;

    @Autowired
    public BlogService(IBlogRepository iBlogRepository) {
        this.iBlogRepository = iBlogRepository;
    }

    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }


    @Override
    public Blog findById(Integer id) {
        return iBlogRepository.findById(id).get();
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable,String search) {
        return iBlogRepository.findByAuthorContaining(pageable,search);
    }

    @Override
    public void remove(Integer id) {
        iBlogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> findByCategoryContains(Pageable pageable, Category category) {
        return iBlogRepository.findByCategory(pageable,category);
    }
}
