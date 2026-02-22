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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        AnimeDatabase animeDb = Room.databaseBuilder(getApplicationContext(),
                        AnimeDatabase.class, "AnimeDB")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries().build();

        Button addUserButton = findViewById(R.id.addUserButton);
        Button existingUserButton = findViewById(R.id.existingUserButton);

        Intent switchToAddUser = new Intent(this, AddUserActivity.class);
        addUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(switchToAddUser);
            }
        });



        Intent switchToExistingUser = new Intent(this, ExistingUserActivity.class);
        existingUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(switchToExistingUser);
            }
        });

    }
}