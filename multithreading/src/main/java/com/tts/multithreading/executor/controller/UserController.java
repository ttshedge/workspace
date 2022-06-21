package com.tts.multithreading.executor.controller;

import com.tts.multithreading.executor.entity.User;
import com.tts.multithreading.executor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "users", consumes = {"application/json"}, produces = "application/json")
    public CompletableFuture<List<User>> saveUsers(@RequestBody List<User> users) {
        return userService.saveUsers(users);
    }

    @GetMapping(value = "users", produces = "application/json")
    public ResponseEntity findUsers() {
        CompletableFuture<List<User>> users = userService.findAllUsers();
        CompletableFuture<List<User>> users1 = userService.findAllUsers();
        CompletableFuture<List<User>> users2 = userService.findAllUsers();
        CompletableFuture.allOf(users, users1, users2).join();
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
