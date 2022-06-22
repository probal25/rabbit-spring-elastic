package com.probal.springmysql.controller;

import com.probal.springmysql.client.SearchClient;
import com.probal.springmysql.dto.UserDto;
import com.probal.springmysql.model.User;
import com.probal.springmysql.searchRequest.UserSearchRequestDTO;
import com.probal.springmysql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    private final SearchClient searchClient;

    @Autowired
    public UserController(UserService service, SearchClient searchClient) {
        this.service = service;
        this.searchClient = searchClient;
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

    @GetMapping("/send_to_mq")
    public void sendAllUserDataToMessageQueue() {
        service.sendAllUserDataToMessageQueue();
    }

    @PostMapping("/search")
    public ResponseEntity<?> search(@RequestBody final UserSearchRequestDTO requestDTO) {

        List<UserDto> searchResults = searchClient.getSearchResults(requestDTO);

        return ResponseEntity.ok(searchResults);
    }

}
