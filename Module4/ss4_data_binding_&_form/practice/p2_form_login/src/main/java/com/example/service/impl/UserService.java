package com.example.service.impl;

import com.example.model.Login;
import com.example.model.User;
import com.example.repository.IUserRepository;
import com.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;
    @Override
    public User checkLogin(Login login) {
        return iUserRepository.checkLogin(login);
    }
}
