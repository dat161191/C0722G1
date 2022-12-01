package com.example.service;

import com.example.model.OderBook;

import java.util.List;

public interface IOderBookService {
    List<OderBook> findAll();

    void saveOder(OderBook oderBook);

    OderBook findByBookRentalCode(long bookRentalCode);
}
