package com.example.cinema.repository;

import com.example.cinema.model.NameMovie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INameMovieRepository extends JpaRepository<NameMovie,Integer> {

}
