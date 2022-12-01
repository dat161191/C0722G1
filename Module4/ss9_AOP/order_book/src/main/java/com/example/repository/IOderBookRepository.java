package com.example.repository;

import com.example.model.OderBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOderBookRepository extends JpaRepository<OderBook,Integer> {
}
