package com.example.user_experience_backend.repository;

import com.example.user_experience_backend.models.Games;
import com.example.user_experience_backend.models.Progress;
import com.example.user_experience_backend.models.Subjects;
import com.example.user_experience_backend.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProgressRepository extends JpaRepository<Progress, Long> {
    Optional<Progress> findByUserAndSubjectAndGame(Users user, Subjects subject, Games game);
}
