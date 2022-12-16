package com.example.cinema.service.impl;

import com.example.cinema.model.NameMovie;
import com.example.cinema.repository.INameMovieRepository;
import com.example.cinema.service.INameMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NameMovieService implements INameMovieService {
    @Autowired
    private INameMovieRepository nameMovieRepository;
    @Override
    public List<NameMovie> findAll() {
        return nameMovieRepository.findAll();
    }

    @Override
    public NameMovie findById(Integer id) {
        return nameMovieRepository.findById(id).get();
    }
}
