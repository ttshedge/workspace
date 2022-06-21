package com.tts.multithreading.executor.service;

import com.tts.multithreading.executor.entity.User;
import com.tts.multithreading.executor.repository.UserRepository;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Async
    public CompletableFuture<List<User>> saveUsers(List<User> users) {
        long start = System.currentTimeMillis();
        log.info("Current thread = {}", Thread.currentThread());
        users = userRepository.saveAll(users);
        long end = System.currentTimeMillis();
        log.info("Execution time = {}", (end - start));
        return CompletableFuture.completedFuture(users);
    }

    @Async
    public CompletableFuture<List<User>> findAllUsers() {
        long start = System.currentTimeMillis();
        log.info("Current thread = {}", Thread.currentThread());
        List<User> users = userRepository.findAll();
        long end = System.currentTimeMillis();
        log.info("Execution time = {}", (end - start));
        return CompletableFuture.completedFuture(users);
    }
}
