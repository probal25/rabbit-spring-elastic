package com.probal.springmysql.service;

import com.probal.springmysql.model.User;
import com.probal.springmysql.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void saveUser(User user) {
        userRepo.save(user);
    }

    public User findUserById(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    public List<User> getUserList() {
        return userRepo.findAll();
    }

    public void saveUserList(List<User> users) {
        userRepo.saveAll(users);
    }
}
