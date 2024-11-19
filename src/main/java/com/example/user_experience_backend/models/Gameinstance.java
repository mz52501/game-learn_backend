package com.example.user_experience_backend.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "gameinstance")
public class Gameinstance {

    @Id
    @GeneratedValue
    @Column(name = "gameinstance_id")
    private long gameinstanceId;

    @ManyToOne  // Many game instances can belong to one user
    @JoinColumn(name = "user_id", nullable = false)  // Foreign key to User
    @JsonIgnore
    private Users user;

    @ManyToOne  // Many game instances can be associated with one game
    @JoinColumn(name = "game_id", nullable = false)  // Foreign key to Game
    @JsonIgnore
    private Games game;

    @ManyToOne  // Many game instances can be associated with one game
    @JoinColumn(name = "subject_id", nullable = false)  // Foreign key to Game
    @JsonIgnore
    private Subjects subject;

    private long score;

    @Column(name = "max_score")
    private long maxScore;

    private java.sql.Timestamp startTime;

    private java.sql.Timestamp endTime;


    public long getGameinstanceId() {
        return gameinstanceId;
    }

    public void setGameinstanceId(long gameinstanceId) {
        this.gameinstanceId = gameinstanceId;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Games getGame() {
        return game;
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

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }


    public long getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(long maxScore) {
        this.maxScore = maxScore;
    }


    public java.sql.Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(java.sql.Timestamp startTime) {
        this.startTime = startTime;
    }


    public java.sql.Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(java.sql.Timestamp endTime) {
        this.endTime = endTime;
    }

}
