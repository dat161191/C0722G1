package com.example.e1_form_register_dto.service;

import com.example.e1_form_register_dto.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ISongService {
    void save(Song song);

    Optional<Song> findById(Integer id);

    Page<Song> findAll(Pageable pageable);

    void  remove(Integer id);
}
