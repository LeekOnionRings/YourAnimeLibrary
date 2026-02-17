package com.example.youranimelibrary;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Anime {

    @PrimaryKey(autoGenerate = true)
    int animeID;

    int userID;

    String animeName;
    String animeGenre;
    boolean toWatch;
    boolean favorite;
    int animeRating;

    public Anime(String animeName, String animeGenre, boolean toWatch, boolean favorite, int animeRating) {
        this.animeName = animeName;
        this.animeGenre = animeGenre;
        this.toWatch = toWatch;
        this.favorite = favorite;
        this.animeRating = animeRating;
    }

    public int getUserID() {
        return userID;
    }

    public String getAnimeName() {
        return animeName;
    }

    public void setAnimeName(String animeName) {
        this.animeName = animeName;
    }

    public String getAnimeGenre() {
        return animeGenre;
    }

    public void setAnimeGenre(String animeGenre) {
        this.animeGenre = animeGenre;
    }

    public boolean getToWatch() {
        return toWatch;
    }

    public void setToWatch(boolean toWatch) {
        this.toWatch = toWatch;
    }

    public boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public int getAnimeRating() {
        return animeRating;
    }

    public void setAnimeRating(int animeRating) {
        this.animeRating = animeRating;
    }

    public String toString() {
        return "SavedAnimeID: " + animeID + "; " + "User " + userID + " saved the Anime: " +
                animeName + "; Genre: " + animeGenre + "; Watched Yet? " +
                toWatch + "; Favorite? " + favorite + "; Rating: " + animeRating;
    }

}

