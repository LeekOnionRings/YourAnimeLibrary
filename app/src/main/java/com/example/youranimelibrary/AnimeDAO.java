package com.example.youranimelibrary;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.room.Delete;
import java.util.List;

@Dao
public interface AnimeDAO {

    @Insert
    void addAnime(Anime a);

    @Update
    void updateAnime(Anime a);

    @Delete
    void deleteAnime(Anime a);

    @Query("SELECT * FROM Anime WHERE animeID = :animeID")
    Anime getAnime(int animeID);

    @Query("SELECT * FROM Anime ORDER BY animeID")
    List<Anime> getAllAnimes();

}
