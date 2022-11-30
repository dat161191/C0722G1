package com.e2_song_dto_validate.codegym.repository;

import com.e2_song_dto_validate.codegym.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Integer> {
}
