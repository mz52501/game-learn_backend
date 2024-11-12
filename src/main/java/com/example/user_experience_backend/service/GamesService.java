package com.example.user_experience_backend.service;

import com.example.user_experience_backend.models.Games;
import com.example.user_experience_backend.models.Gamesubject;
import com.example.user_experience_backend.models.Subjects;
import com.example.user_experience_backend.repository.GamesRepository;
import com.example.user_experience_backend.repository.GamesubjectRepository;
import com.example.user_experience_backend.repository.SubjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class GamesService {

    @Autowired
    private SubjectsRepository subjectsRepository;

    @Autowired
    private GamesRepository gamesRepository;

    @Autowired
    private GamesubjectRepository gamesubjectRepository;

    public List<Games> getGamesOfSubject(Long id) {
        Subjects subject = subjectsRepository.findById(id).orElse(null);
        if (subject != null) {
            List<Games> games = new LinkedList<>();
            for (Gamesubject gs : subject.getGamesubjects()) {
                if (!games.contains(gs.getGame())) games.add(gs.getGame());
            }
            return games;
        } else return null;
    }
}
