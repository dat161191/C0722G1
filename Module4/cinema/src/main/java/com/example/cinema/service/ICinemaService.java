package com.example.cinema.service;

import com.example.cinema.dto.CinemaDto;
import com.example.cinema.model.Cinema;
import com.example.cinema.model.NameMovie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICinemaService {
    Page<Cinema> findByNameMovieAndDateContains(NameMovie nameMovie, String date, Pageable pageable);
    Page<Cinema> findByDateContains(String date, Pageable pageable);

//    Page<CinemaDto> findByNameMovieAndDateContains(NameMovie nameMovie, String date, Pageable pageable);
//    Page<CinemaDto> findByDateContains(String date, Pageable pageable);

    void save(Cinema cinema);

    void delete(Integer id);

    Cinema findByID(Integer id);

}
