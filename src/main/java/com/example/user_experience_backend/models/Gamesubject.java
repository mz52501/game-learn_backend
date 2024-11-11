package com.example.user_experience_backend.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "gamesubject")
public class Gamesubject {

    @Id
    @GeneratedValue
    @Column(name = "gamesubject_id")
    private long gamesubjectId;


    @ManyToOne
    @JoinColumn(name = "game_id")
    @JsonIgnore
    private Games game;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    @JsonIgnore
    private Subjects subject;

    @ManyToOne
    @JoinColumn(name = "gamedata_id")
    @JsonIgnore
    private Gamedata gamedata;
    
    private String contentType;

    public Games getGame() {
        return game;
    }


    public long getGamesubjectId() {
        return gamesubjectId;
    }

    public void setGamesubjectId(long gamesubjectId) {
        this.gamesubjectId = gamesubjectId;
    }

    public void setGame(Games game) {
        this.game = game;
    }

    public Subjects getSubject() {
        return subject;
    }

    public void setSubject(Subjects subject) {
        this.subject = subject;
    }

    public Gamedata getGamedata() {
        return gamedata;
    }

    public void setGamedata(Gamedata gamedata) {
        this.gamedata = gamedata;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

}
