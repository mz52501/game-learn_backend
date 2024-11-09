package com.example.user_experience_backend.models;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "subjects")
public class Subjects {

    @Id
    @GeneratedValue
    @Column(name = "subject_id")
    private long subjectId;

    private String name;

    @OneToMany(mappedBy = "subject")  // One subject can have many game instances
    private List<Gameinstance> gameinstances;

    @OneToMany(mappedBy = "subject")
    private List<Gamesubject> gamesubjects;

    @OneToMany(mappedBy = "subject")  // One subject can have many progresses
    private List<Progress> progresses;

    public long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Gameinstance> getGameinstances() {
        return gameinstances;
    }

    public void setGameinstances(List<Gameinstance> gameinstances) {
        this.gameinstances = gameinstances;
    }

    public List<Gamesubject> getGamesubjects() {
        return gamesubjects;
    }

    public void setGamesubjects(List<Gamesubject> gamesubjects) {
        this.gamesubjects = gamesubjects;
    }

    public List<Progress> getProgresses() {
        return progresses;
    }

    public void setProgresses(List<Progress> progresses) {
        this.progresses = progresses;
    }
}
