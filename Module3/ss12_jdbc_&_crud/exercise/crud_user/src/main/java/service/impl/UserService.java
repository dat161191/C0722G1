package service.impl;

import model.User;
import repository.IUserRepository;
import repository.impl.UserRepository;
import service.IUserService;

import java.util.List;

public class UserService implements IUserService {
    private IUserRepository userRepository = new UserRepository();

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public boolean add(User user) {
        return userRepository.add(user);
    }

    @Override
    public User findByID(int id) {
        return userRepository.findByID(id);
    }

    @Override
    public List<User> findByCountry(String country) {
        return userRepository.findByCountry(country);
    }

    @Override
    public boolean update(int id, User product) {
       return userRepository.update(id, product);
    }

    @Override
    public boolean remove(int id) {
        return userRepository.remove(id);
    }
}
