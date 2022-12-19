package com.example.cinema.service.impl;

import com.example.cinema.dto.CinemaDto;
import com.example.cinema.model.Cinema;
import com.example.cinema.model.NameMovie;
import com.example.cinema.repository.ICinemaRepository;
import com.example.cinema.service.ICinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaService implements ICinemaService {
    @Autowired
    private ICinemaRepository cinemaRepository;

    @Override
    public Page<Cinema> findByNameMovieAndDateContains(NameMovie nameMovie, String date, Pageable pageable) {
        return cinemaRepository.findByNameMovieAndDateContains(nameMovie, date, pageable);
    }
//    @Override
//    public Page<CinemaDto> findByNameMovieAndDateContains(NameMovie nameMovie, String date, Pageable pageable) {
//        return cinemaRepository.findByNameMovieAndDateContains(nameMovie, date, pageable);
//    }

    @Override
    public Page<Cinema> findByDateContains(String date, Pageable pageable) {
        return cinemaRepository.findByDateContains(date, pageable);
    }
//    @Override
//    public Page<CinemaDto> findByDateContains(String date, Pageable pageable) {
//        return cinemaRepository.findByDateContains(date, pageable);
//    }

    @Override
    public void save(Cinema cinema) {
        cinemaRepository.save(cinema);
    }

    @Override
    public void delete(Integer id) {
        cinemaRepository.deleteById(id);
    }

    @Override
    public Cinema findByID(Integer id) {
        return cinemaRepository.findById(id).get();
    }

}
