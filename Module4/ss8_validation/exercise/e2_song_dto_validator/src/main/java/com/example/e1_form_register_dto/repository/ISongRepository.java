package com.example.e1_form_register_dto.repository;

import com.example.e1_form_register_dto.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongRepository extends JpaRepository<Song,Integer> {
}
