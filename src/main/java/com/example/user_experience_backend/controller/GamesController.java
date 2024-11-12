package com.example.user_experience_backend.controller;

import com.example.user_experience_backend.models.Games;
import com.example.user_experience_backend.models.Subjects;
import com.example.user_experience_backend.repository.GamesRepository;
import com.example.user_experience_backend.repository.SubjectsRepository;
import com.example.user_experience_backend.service.GamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.Subject;
import java.util.List;

@RestController
public class GamesController {

    @Autowired
    GamesService gamesService;

    private final GamesRepository gamesRepository;
    private final SubjectsRepository subjectsRepository;

    public GamesController(GamesRepository gamesRepository, SubjectsRepository subjectsRepository) {
        this.gamesRepository = gamesRepository;
        this.subjectsRepository = subjectsRepository;
    }

    @GetMapping("/subject/{id}/games")
    public ResponseEntity<List<Games>> getGamesofSubject(@PathVariable Long id) {
        List<Games> games = gamesService.getGamesOfSubject(id);
        if (games != null) {
            return ResponseEntity.ok(games);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
