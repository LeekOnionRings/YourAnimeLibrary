package com.example.youranimelibrary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.List;

public class ViewAnimeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_view_anime);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        AnimeDatabase animeDb = Room.databaseBuilder(getApplicationContext(),
                        AnimeDatabase.class, "AnimeDB")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries().build();

        int receievedUserID = getIntent().getIntExtra("oneUniqueUser", 0);
        List<UsersWithAnimes> getAllAnimes = animeDb.usersWithAnimesDAO().getUserWithAnimes(receievedUserID);
        Button addAnimeButton = findViewById(R.id.addAnimeButton);

        Intent switchToAddAnime = new Intent(this, AddAnimeActivity.class);
        addAnimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToAddAnime.putExtra("userID", receievedUserID);
                startActivity(switchToAddAnime);
            }
        });


        //Do this but for animes
        List<Anime> getAnimeList = animeDb.animeDAO().getAllAnimes();
        RecyclerView animeRV = findViewById(R.id.animeRecyclerView);
        animeRV.setLayoutManager(new LinearLayoutManager(this));
        animeRV.setAdapter(new CustomAdapter2(getAnimeList));


    }
}