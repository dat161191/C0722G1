package com.example.service.impl;

import com.example.model.Book;
import com.example.repository.IBookRepository;
import com.example.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookService implements IBookService {
    @Autowired
    IBookRepository iBookRepository;
    @Override
    public List<Book> findAll() {
        return iBookRepository.findAll();
    }

    @Override
    public Book findById(int id) {
        return iBookRepository.findById(id).orElse(new Book());    }

    @Override
    public void saveBook(Book book) {
        iBookRepository.save(book);
    }
}
