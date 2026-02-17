package com.example.youranimelibrary;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

public class AddUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_user);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        AnimeDatabase animeDb = Room.databaseBuilder(getApplicationContext(),
                AnimeDatabase.class, "AnimeDB")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries().build();

        EditText editAddUsername = findViewById(R.id.addUserEditText);
        Button addUsernameButton = findViewById(R.id.addUsernameButton);
        Intent switchToMainActivity = new Intent(this, MainActivity.class);

        addUsernameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editAddUsername.getText().toString();
                User u = new User(username);
                animeDb.userDAO().addUser(u);

                Log.i("TestTestInAdd", animeDb.userDAO().getUser(1).getUsername());

                startActivity(switchToMainActivity);

            }
        });



    }
}