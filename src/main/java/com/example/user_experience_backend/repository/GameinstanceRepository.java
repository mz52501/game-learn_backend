package com.example.user_experience_backend.repository;

import com.example.user_experience_backend.models.Gameinstance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameinstanceRepository extends JpaRepository<Gameinstance, Long> {
}
