package com.example.user_experience_backend.models;


import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "shapes")
@PrimaryKeyJoinColumn(name = "gamedata_id")  // The primary key of the Words table is the same as the supertype
public class Shapes extends Gamedata {

}
