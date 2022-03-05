package com.probal.springmysql.controller;

import com.probal.springmysql.model.User;
import com.probal.springmysql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/")
    public void userSave(@RequestBody final User user) {
        service.saveUser(user);
    }

    @GetMapping("/{id}")
    public User findUser(@PathVariable final Long userId) {
        return service.findUserById(userId);
    }

    @GetMapping("/all")
    public List<User> getAllUser() {
        return service.getUserList();
    }

    @PostMapping("/all")
    public void saveAllUser(@RequestBody List<User> users) {
        service.saveUserList(users);
    }
}
