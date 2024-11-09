package com.example.user_experience_backend.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "games")
public class Games {

    @Id  // Marks this field as the primary key
    @GeneratedValue  // Auto-generates ID values
    @Column(name = "game_id")  // Maps this field to the "game_id" column in the database
    private long gameId;

    private String name;

    private String description;

    @OneToMany(mappedBy = "game")  // One game can have many game instances
    private List<Gameinstance> gameinstances;

    @OneToMany(mappedBy = "game")
    private List<Gamesubject> gamesubjects;

    @OneToMany(mappedBy = "game")
    private List<Progress> progresses;

    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
