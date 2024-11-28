package com.example.user_experience_backend.service;

import com.example.user_experience_backend.DTO.LoginDTO;
import com.example.user_experience_backend.DTO.ProgressDTO;
import com.example.user_experience_backend.DTO.SubjectDTO;
import com.example.user_experience_backend.models.*;
import com.example.user_experience_backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class GamesService {

    @Autowired
    private SubjectsRepository subjectsRepository;

    @Autowired
    private GamesRepository gamesRepository;

    @Autowired
    private GamesubjectRepository gamesubjectRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private GameinstanceRepository gameinstanceRepository;

    @Autowired
    private ProgressRepository progressRepository;

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

    public List<Gamedata> getGamedataForSubjectGame(Long subjectId, Long gameId) {
        Subjects subject = subjectsRepository.findById(subjectId).orElse(null);
        if (subject != null) {
            List<Gamedata> gameData = new LinkedList<>();
            for (Gamesubject gs : subject.getGamesubjects()) {
                if (gs.getGame().getGameId() == gameId) gameData.add(gs.getGamedata());
            }
            return gameData;
        } else return null;
    }

    public List<ProgressDTO> getGamesPlayedAndProgress(Long userId) {
        Users user = usersRepository.findById(userId).orElse(null);
        if (user != null) {
            List<ProgressDTO> list = new LinkedList<>();
            for (Progress p : user.getProgresses()) {
                list.add(new ProgressDTO(p, user));
            }
            return list;
        } else return null;
    }

    public List<SubjectDTO> getSubjectGroupedProgresses(Long userId) {
        Users user = usersRepository.findById(userId).orElse(null);
        if (user == null) {
            return Collections.emptyList();
        }

        // Group progresses by subject name
        Map<String, List<Progress>> groupedBySubject = user.getProgresses()
            .stream()
            .collect(Collectors.groupingBy(progress -> progress.getSubject().getName()));

        // Create SubjectDTO objects
        List<SubjectDTO> subjectDTOs = new ArrayList<>();
        for (Map.Entry<String, List<Progress>> entry : groupedBySubject.entrySet()) {
            String subjectName = entry.getKey();
            List<ProgressDTO> progresses = entry.getValue().stream()
                .map(progress -> new ProgressDTO(progress, user)) // Convert Progress to ProgressDTO
                .collect(Collectors.toList());

            // Add a new SubjectDTO for this subject
            subjectDTOs.add(new SubjectDTO(subjectName, progresses));
        }

        return subjectDTOs;
    }

    public Users checkAuth(LoginDTO loginDTO) {
        return usersRepository.findByUsername(loginDTO.getUsername())
            .filter(user -> user.getPassword().equals(loginDTO.getPassword()))
            .orElse(null);
    }
}
