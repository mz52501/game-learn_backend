package com.example.user_experience_backend.controller;

import com.example.user_experience_backend.repository.GamesubjectRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GamesubjectController {


    private final GamesubjectRepository gamesubjectRepository;

    public GamesubjectController(GamesubjectRepository gamesubjectRepository) {
        this.gamesubjectRepository = gamesubjectRepository;
    }

}
