package com.example.user_experience_backend.models;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private long userId;

    private String username;

    private java.sql.Date dob;

    private String password;

    @OneToMany(mappedBy = "user")  // One user can have many game instances
    private List<Gameinstance> gameinstances;

    @OneToMany(mappedBy = "user")  // One user can have many progesses
    private List<Progress> progresses;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public java.sql.Date getDob() {
        return dob;
    }

    public void setDob(java.sql.Date dob) {
        this.dob = dob;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Gameinstance> getGameinstances() {
        return gameinstances;
    }

    public void setGameinstances(List<Gameinstance> gameinstances) {
        this.gameinstances = gameinstances;
    }

    public List<Progress> getProgresses() {
        return progresses;
    }

    public void setProgresses(List<Progress> progresses) {
        this.progresses = progresses;
    }
}
