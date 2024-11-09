package com.example.user_experience_backend.models;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "gamedata")
@Inheritance(strategy = InheritanceType.JOINED)  // Specifies the joined strategy
public class Gamedata {

    @Id
    @GeneratedValue
    @Column(name = "gamedata_id")
    private long gamedataId;

    private long difficultyLevel;

    private String name;

    private String imagePath;

    @OneToMany(mappedBy = "gamedata")
    private List<Gamesubject> gamesubjects;


    public long getGamedataId() {
        return gamedataId;
    }

    public void setGamedataId(long gamedataId) {
        this.gamedataId = gamedataId;
    }


    public long getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(long difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public List<Gamesubject> getGamesubjects() {
        return gamesubjects;
    }

    public void setGamesubjects(List<Gamesubject> gamesubjects) {
        this.gamesubjects = gamesubjects;
    }
}
