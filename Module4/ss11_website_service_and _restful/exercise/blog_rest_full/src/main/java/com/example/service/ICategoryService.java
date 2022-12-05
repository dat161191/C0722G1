package com.example.service;
import com.example.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    Category findById(Integer id);

    void save(Category category);

    Page<Category> findByDeleted(Pageable pageable);

    void remove(Integer id);

    Page<Category> findByCategoryContains(Pageable pageable, Category category);
}
