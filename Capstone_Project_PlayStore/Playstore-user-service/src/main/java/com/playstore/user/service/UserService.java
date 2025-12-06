package com.playstore.user.service;

import com.playstore.user.model.User;
import com.playstore.user.repositry.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public User register(User user) {
        return repo.save(user);
    }

    public User login(String email, String password) {
        return repo.findByEmail(email)
                   .filter(u -> u.getPassword().equals(password))
                   .orElse(null);
    }

    public User findByEmail(String email) {
        return repo.findByEmail(email).orElse(null);
    }

    public List<User> getAllUsers() {
        return repo.findAll();
    }
}

