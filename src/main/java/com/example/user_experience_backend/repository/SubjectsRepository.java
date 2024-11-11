package com.example.user_experience_backend.repository;

import com.example.user_experience_backend.models.Subjects;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectsRepository extends JpaRepository<Subjects, Long> {
}
