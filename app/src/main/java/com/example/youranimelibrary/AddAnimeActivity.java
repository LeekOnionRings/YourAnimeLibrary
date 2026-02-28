package com.example.youranimelibrary;

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


        //Testing
        /*watchedRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull RadioGroup group, int checkedId) {
                View watchedRB = watchedRG.findViewById(watchedRG.getCheckedRadioButtonId());
                int watchedIndex = watchedRG.indexOfChild(watchedRB);
                Log.i("testRadioButton", String.valueOf(watchedIndex)); //0 for yes, //1 for no
            }
        });*/

        addAnimeToDatabaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String officialAnimeName = editAnimeName.getText().toString();
                String officialAnimeGenre = editAnimeGenre.getText().toString();

            }
        });


    }

}