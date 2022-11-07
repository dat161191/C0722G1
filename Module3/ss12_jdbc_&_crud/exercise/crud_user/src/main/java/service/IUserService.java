package service;

import model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    boolean add(User product);
    User findByID(int id);
    List<User> findByCountry(String country);
    boolean update(int id, User user);
    boolean remove(int id);
}
