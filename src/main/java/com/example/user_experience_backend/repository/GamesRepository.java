package com.example.user_experience_backend.repository;

import com.example.user_experience_backend.models.Games;
import com.example.user_experience_backend.models.Gamesubject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GamesRepository extends JpaRepository<Games, Long> {
}
