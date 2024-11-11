package com.example.user_experience_backend.controller;

import com.example.user_experience_backend.models.Subjects;
import com.example.user_experience_backend.repository.SubjectsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SubjectsController {

    private final SubjectsRepository repository;

    public SubjectsController(SubjectsRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/subject")
    List<Subjects> getSubjects() {
        return repository.findAll();
    }
}
