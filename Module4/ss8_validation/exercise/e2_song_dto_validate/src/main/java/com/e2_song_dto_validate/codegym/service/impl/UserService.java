package com.e2_song_dto_validate.codegym.service.impl;

import com.e2_song_dto_validate.codegym.model.User;
import com.e2_song_dto_validate.codegym.repository.IUserRepository;
import com.e2_song_dto_validate.codegym.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;
    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
}
