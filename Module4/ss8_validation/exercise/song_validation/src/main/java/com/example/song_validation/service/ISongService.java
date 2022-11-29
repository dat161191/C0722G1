package com.example.song_validation.service;

import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ISongService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Integer id);

    void save(T t);

    void remove(Integer id);
}
