package com.example.user_experience_backend.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "words")
@PrimaryKeyJoinColumn(name = "gamedata_id")  // The primary key of the Words table is the same as the supertype
public class Words extends Gamedata {

    private String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
