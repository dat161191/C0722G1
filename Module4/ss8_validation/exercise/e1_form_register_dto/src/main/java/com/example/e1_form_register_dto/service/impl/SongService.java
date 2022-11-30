package com.example.e1_form_register_dto.service.impl;

import com.example.e1_form_register_dto.model.Song;
import com.example.e1_form_register_dto.repository.ISongRepository;
import com.example.e1_form_register_dto.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SongService implements ISongService {
    @Autowired
    private ISongRepository songRepository;

    @Override
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    public Optional<Song> findById(Integer id) {
        return songRepository.findById(id);
    }

    @Override
    public Page<Song> findAll(Pageable pageable) {
        return songRepository.findAll(pageable);
    }

    @Override
    public void remove(Integer id) {
        songRepository.deleteById(id);
    }
}
