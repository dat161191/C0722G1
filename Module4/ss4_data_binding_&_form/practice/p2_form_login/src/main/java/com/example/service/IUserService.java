package com.example.service;

import com.example.model.Login;
import com.example.model.User;

public interface IUserService {
    User checkLogin(Login login);
}
