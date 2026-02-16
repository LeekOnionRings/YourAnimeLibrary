package com.example.youranimelibrary;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.room.Delete;

@Dao
public interface UserDAO {

    @Insert
    void addUser(User u);

    @Update
    void updateUser(User u);

    @Delete
    void deleteUser(User u);

    @Query("SELECT * FROM USER WHERE userID = :userID")
    User getUser(int userID);






}
