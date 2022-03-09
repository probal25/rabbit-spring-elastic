package com.probal.springmysql.service;

import com.probal.springmysql.model.User;
import com.probal.springmysql.repository.UserRepo;
import com.probal.springmysql.producer.publisher.UserPublisherImpl;
import com.probal.springmysql.producer.utill.CustomMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService {

    private final UserRepo userRepo;
    private final UserPublisherImpl userConsumer;

    @Autowired
    public UserService(UserRepo userRepo, UserPublisherImpl userConsumer) {
        this.userRepo = userRepo;
        this.userConsumer = userConsumer;
    }

    public void saveUser(User user) {
        try {
        userRepo.saveAndFlush(user);
        CustomMessage userCustomMessage = new CustomMessage(user);
        userConsumer.publishMessage(userCustomMessage);
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
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

    public void sendAllUserDataToMessageQueue() {
        List<User> userList = userRepo.findAll();
        for (User user : userList) {
            try {
                CustomMessage userCustomMessage = new CustomMessage(user);
                userConsumer.publishMessage(userCustomMessage);
            } catch (Exception e) {
                log.error(e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
