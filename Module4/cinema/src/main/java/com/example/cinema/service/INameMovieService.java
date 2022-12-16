package com.example.cinema.service;

import com.example.cinema.model.NameMovie;

import java.util.List;

public interface INameMovieService {
    List<NameMovie> findAll();
    NameMovie findById(Integer id);
}
