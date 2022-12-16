package com.example.cinema.repository;

import com.example.cinema.model.Cinema;
import com.example.cinema.model.NameMovie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICinemaRepository extends JpaRepository<Cinema,Integer> {
    Page<Cinema> findByNameMovieAndDateContains(NameMovie nameMovie, String date, Pageable pageable);
    Page<Cinema> findByDateContains(String date,Pageable pageable);
}
