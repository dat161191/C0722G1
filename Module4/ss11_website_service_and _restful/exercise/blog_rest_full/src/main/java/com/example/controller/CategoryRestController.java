package com.example.controller;

import com.example.model.Blog;
import com.example.model.Category;
import com.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("categories")
public class CategoryRestController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("{page}")
    public ResponseEntity<Page<Category>> getList(@PathVariable("page") int page) {
        Pageable pageable = PageRequest.of(page - 1, 3);
        Page<Category> categoryList = categoryService.findByDeleted(pageable);
        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }



}
