package repository;

import model.User;

import java.util.List;

public interface IUserRepository {
    List<User> findAll();
    boolean add(User user);
    User findByID(int id);
    List<User> findByCountry(String country);
    boolean update(int id, User user);
    boolean remove(int id);

}
