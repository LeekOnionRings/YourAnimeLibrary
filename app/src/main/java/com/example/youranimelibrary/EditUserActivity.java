package com.example.youranimelibrary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

public class EditUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_edit_user);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        AnimeDatabase animeDb = Room.databaseBuilder(getApplicationContext(),
                        AnimeDatabase.class, "AnimeDB")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries().build();

        EditText editUserTextView = findViewById(R.id.editUserEditText);
        Button editUsernameButton = findViewById(R.id.editUsernameButton);

        int receievedUserID = getIntent().getIntExtra("oneUniqueUser", 0);
        User selectedUser = animeDb.userDAO().getUser(receievedUserID);
        editUserTextView.setText(selectedUser.getUsername());

        Intent switchToExistingUser = new Intent(this, ExistingUserActivity.class);
        editUsernameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedUser.setUsername(editUserTextView.getText().toString());
                animeDb.userDAO().updateUser(selectedUser);
                startActivity(switchToExistingUser);
            }
        });


    }
}