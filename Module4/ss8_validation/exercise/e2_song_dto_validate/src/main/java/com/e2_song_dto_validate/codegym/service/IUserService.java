package com.e2_song_dto_validate.codegym.service;

import com.e2_song_dto_validate.codegym.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService {
    void save(User user);

    Page<User> findAll(Pageable pageable);

}
