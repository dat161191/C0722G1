package com.example.song_validation.service.impl;

import com.example.song_validation.model.Song;
import com.example.song_validation.repository.ISongRepository;
import com.example.song_validation.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService implements ISongService<Song> {

    @Autowired
    private ISongRepository repository;

    @Override
    public List<Song> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Song> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public void save(Song song) {
        repository.save(song);
    }

    @Override
    public void remove(Integer id) {
        repository.deleteById(id);
    }
}
