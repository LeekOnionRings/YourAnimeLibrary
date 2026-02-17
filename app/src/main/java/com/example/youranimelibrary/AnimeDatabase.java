package com.example.youranimelibrary;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Anime.class, User.class}, version = 1)
public abstract class AnimeDatabase extends RoomDatabase {
    public abstract AnimeDAO animeDAO();
    public abstract UserDAO userDAO();
    public abstract UsersWithAnimesDAO usersWithAnimesDAO();
}
