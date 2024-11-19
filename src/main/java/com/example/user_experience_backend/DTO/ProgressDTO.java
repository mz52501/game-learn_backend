package com.example.user_experience_backend.DTO;

import com.example.user_experience_backend.models.Gameinstance;
import com.example.user_experience_backend.models.Progress;
import com.example.user_experience_backend.models.Users;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

public class ProgressDTO {
    private long progressId;
    private Long progressLevel;
    private long totalPoints;
    private String badgesUnlocked;
    private java.sql.Timestamp lastPlayed;
    private String subject;
    private String game;
    private List<Gameinstance> gameinstanceList;
    private double accuracy;

    public ProgressDTO(Progress progress, Users user) {
        this.progressId = progress.getProgressId();
        this.progressLevel = progress.getProgressLevel();
        this.totalPoints = progress.getTotalPoints();
        this.badgesUnlocked = progress.getBadgesUnlocked();
        this.lastPlayed = progress.getLastPlayed();
        this.subject = progress.getSubject().getName();
        this.game = progress.getGame().getName();
        this.gameinstanceList = user.getGameinstances().stream().filter((gameinstance -> gameinstance.getSubject().getSubjectId() == progress.getSubject().getSubjectId() &&
            gameinstance.getGame().getGameId() == progress.getGame().getGameId())).collect(Collectors.toList());
        this.accuracy = (double) this.gameinstanceList.stream().mapToLong(Gameinstance::getScore).sum() / this.gameinstanceList.stream().mapToLong(Gameinstance::getMaxScore).sum();
    }

    public long getProgressId() {
        return progressId;
    }

    public void setProgressId(long progressId) {
        this.progressId = progressId;
    }

    public Long getProgressLevel() {
        return progressLevel;
    }

    public void setProgressLevel(Long progressLevel) {
        this.progressLevel = progressLevel;
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

    public Timestamp getLastPlayed() {
        return lastPlayed;
    }

    public void setLastPlayed(Timestamp lastPlayed) {
        this.lastPlayed = lastPlayed;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public List<Gameinstance> getGameinstanceList() {
        return gameinstanceList;
    }

    public void setGameinstanceList(List<Gameinstance> gameinstanceList) {
        this.gameinstanceList = gameinstanceList;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }
}
