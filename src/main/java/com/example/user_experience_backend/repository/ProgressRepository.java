package com.example.user_experience_backend.repository;

import com.example.user_experience_backend.models.Progress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgressRepository extends JpaRepository<Progress, Long> {
}
