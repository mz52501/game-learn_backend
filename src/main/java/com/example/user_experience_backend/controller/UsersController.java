package com.example.user_experience_backend.controller;

import com.example.user_experience_backend.DTO.ProgressDTO;
import com.example.user_experience_backend.DTO.SubjectDTO;
import com.example.user_experience_backend.models.Gameinstance;
import com.example.user_experience_backend.models.Games;
import com.example.user_experience_backend.models.Progress;
import com.example.user_experience_backend.models.Users;
import com.example.user_experience_backend.repository.UsersRepository;
import com.example.user_experience_backend.service.GamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class UsersController {

    @Autowired
    GamesService gamesService;

    private final UsersRepository repository;

    UsersController(UsersRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/users")
    List<Users> getUsers() {
        return repository.findAll();
    }

    @GetMapping("/profile/{userId}")
    public ResponseEntity<List<SubjectDTO>> getSubjectGroupedProgresses(@PathVariable Long userId) {
        List<SubjectDTO> list = gamesService.getSubjectGroupedProgresses(userId);
        if (list != null) {
            return ResponseEntity.ok(list);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
