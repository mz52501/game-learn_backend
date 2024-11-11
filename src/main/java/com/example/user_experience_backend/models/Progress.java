package com.example.user_experience_backend.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "progress")
public class Progress {

    @Id
    @GeneratedValue
    @Column(name = "progress_id")
    private long progressId;


    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private Users user;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    @JsonIgnore
    private Subjects subject;

    @ManyToOne
    @JoinColumn(name = "game_id")
    @JsonIgnore
    private Games game;

    private String progressLevel;

    private java.sql.Timestamp lastPlayed;

    private long totalPoints;

    private String badgesUnlocked;


    public long getProgressId() {
        return progressId;
    }

    public void setProgressId(long progressId) {
        this.progressId = progressId;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Subjects getSubject() {
        return subject;
    }

    public void setSubject(Subjects subject) {
        this.subject = subject;
    }

    public Games getGame() {
        return game;
    }

    public void setGame(Games game) {
        this.game = game;
    }

    public String getProgressLevel() {
        return progressLevel;
    }

    public void setProgressLevel(String progressLevel) {
        this.progressLevel = progressLevel;
    }


    public java.sql.Timestamp getLastPlayed() {
        return lastPlayed;
    }

    public void setLastPlayed(java.sql.Timestamp lastPlayed) {
        this.lastPlayed = lastPlayed;
    }


    public long getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(long totalPoints) {
        this.totalPoints = totalPoints;
    }


    public String getBadgesUnlocked() {
        return badgesUnlocked;
    }

    public void setBadgesUnlocked(String badgesUnlocked) {
        this.badgesUnlocked = badgesUnlocked;
    }

}
