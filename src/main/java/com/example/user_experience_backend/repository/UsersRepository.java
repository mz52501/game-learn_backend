package com.example.user_experience_backend.repository;

import com.example.user_experience_backend.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
