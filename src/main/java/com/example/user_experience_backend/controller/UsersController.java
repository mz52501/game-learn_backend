package com.example.user_experience_backend.controller;

import com.example.user_experience_backend.models.Users;
import com.example.user_experience_backend.repository.UsersRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersController {

    private final UsersRepository repository;

    UsersController(UsersRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/users")
    List<Users> getUsers() {
        return repository.findAll();
    }
}
