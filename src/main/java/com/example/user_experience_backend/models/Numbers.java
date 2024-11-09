package com.example.user_experience_backend.models;


import jakarta.persistence.*;

@Entity
@Table(name = "numbers")
@PrimaryKeyJoinColumn(name = "gamedata_id")  // The primary key of the Numbers table is the same as the supertype
public class Numbers extends Gamedata {

    private long value;

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

}
