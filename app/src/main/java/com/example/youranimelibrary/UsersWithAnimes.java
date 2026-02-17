package com.example.youranimelibrary;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class UsersWithAnimes {

    @Embedded
    public User user;

    @Relation(
            parentColumn = "userID",
            entityColumn = "animeID"
    )
    public List<Anime> userAnimes;


}
