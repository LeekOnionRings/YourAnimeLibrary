package com.example.youranimelibrary;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

public class AddAnimeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_anime);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        AnimeDatabase animeDb = Room.databaseBuilder(getApplicationContext(),
                        AnimeDatabase.class, "AnimeDB")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries().build();

        int receivedUserID = getIntent().getIntExtra("userID", 0);
        Button addAnimeToDatabaseButton = findViewById(R.id.addAnimeToDatabaseButton);
        EditText editAnimeName = findViewById(R.id.addAnimeNameEditText);
        EditText editAnimeGenre = findViewById(R.id.addAnimeGenreEditText);
        RadioGroup watchedRG = findViewById(R.id.watchedRadioGroup);
        RadioGroup favoriteRG = findViewById(R.id.favoriteRadioGroup);
        Spinner ratingAnimeSpinner = findViewById(R.id.ratingAnimeSpinner);
        Intent switchToViewAnimeActivity = new Intent(this, ViewAnimeActivity.class);


        addAnimeToDatabaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Boolean haveWatched = false;
                Boolean haveFavorite = false;

                //To add anime name and genre
                String officialAnimeName = editAnimeName.getText().toString();
                Log.i("testAnimeName", officialAnimeName);
                String officialAnimeGenre = editAnimeGenre.getText().toString();
                Log.i("testAnimeGenre", officialAnimeGenre);

                //For radio groups
                View watchedRB = watchedRG.findViewById(watchedRG.getCheckedRadioButtonId());
                int watchedIndex = watchedRG.indexOfChild(watchedRB); //0 for yes, //1 for no
                if(watchedIndex == 0) {
                    haveWatched = true;
                }
                Log.i("testWatchRadioButton", String.valueOf(watchedIndex));

                View favoriteRB = favoriteRG.findViewById(favoriteRG.getCheckedRadioButtonId());
                int favoriteIndex = favoriteRG.indexOfChild(favoriteRB); //0 for yes, //1 for no
                if(favoriteIndex == 0) {
                    haveFavorite = true;
                }
                Log.i("testFavoriteRadioButton", String.valueOf(favoriteIndex));

                //To add rating
                int officialRating = ratingAnimeSpinner.getSelectedItemPosition(); //need to display officialRating + 1
                Log.i("testRating", String.valueOf(officialRating));

                Anime a = new Anime(officialAnimeName, officialAnimeGenre, haveWatched, haveFavorite, officialRating + 1);
                animeDb.animeDAO().addAnime(a);
                Log.i("TestTestAnAdd", animeDb.animeDAO().getAnime(1).getAnimeName());

                startActivity(switchToViewAnimeActivity);
            }
        });



    }

}