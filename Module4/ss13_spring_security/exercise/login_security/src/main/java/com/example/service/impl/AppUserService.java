package com.example.service.impl;

import com.example.model.AppUser;
import com.example.repository.IAppUserRepository;
import com.example.service.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AppUserService implements IAppUserService {
    @Autowired
    private IAppUserRepository iAppUserRepository;
    @Override
    public void create(AppUser user) {
        iAppUserRepository.save(user);
    }
}
