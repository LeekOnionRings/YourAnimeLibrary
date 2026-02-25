package com.example.youranimelibrary;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

@Dao
public interface UsersWithAnimesDAO {

    @Transaction
    @Query("SELECT * FROM Anime WHERE userID = :userID")
    public List<UsersWithAnimes> getUserWithAnimes(int userID);

}
