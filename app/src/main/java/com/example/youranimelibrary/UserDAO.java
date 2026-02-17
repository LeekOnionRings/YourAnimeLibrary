package com.example.youranimelibrary;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.room.Delete;
import java.util.List;

@Dao
public interface UserDAO {

    @Insert
    void addUser(User u);

    @Update
    void updateUser(User u);

    @Delete
    void deleteUser(User u);

    @Query("SELECT * FROM User WHERE userID = :userID")
    User getUser(int userID);

    @Query("SELECT * FROM User ORDER BY userID")
    List<User> getAllUsers();





}
