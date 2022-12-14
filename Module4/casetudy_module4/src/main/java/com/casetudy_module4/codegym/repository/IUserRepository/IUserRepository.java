package com.casetudy_module4.codegym.repository.IUserRepository;

import com.casetudy_module4.codegym.model.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
