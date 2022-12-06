package com.example.service.impl;


import com.example.model.Category;
import com.example.repository.ICategoryRepository;
import com.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository iCategoryRepository;

    @Override
    public List<Category> findAll() {
        return iCategoryRepository.findAll();
    }


    @Override
    public Category findById(Integer id) {
        return iCategoryRepository.findById(id).get();
    }

    @Override
    public void save(Category category) {
        iCategoryRepository.save(category);
    }

    @Override
    public Page<Category> findByDeleted(Pageable pageable) {
        return iCategoryRepository.findByDeleted(false,pageable);
    }

    @Override
    public void remove(Integer id) {
        iCategoryRepository.deleteById(id);
    }

    @Override
    public Page<Category> findByCategoryContains(Pageable pageable, Category category) {
        return null;
    }
}
