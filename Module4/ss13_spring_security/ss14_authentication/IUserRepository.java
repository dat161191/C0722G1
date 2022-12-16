package com.codegym.repository;

import com.codegym.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

// BƯớc 3: Tạo Repo
public interface IUserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
