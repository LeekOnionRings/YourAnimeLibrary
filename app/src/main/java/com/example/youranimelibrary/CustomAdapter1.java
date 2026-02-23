package com.example.youranimelibrary;

import static androidx.core.content.ContextCompat.startActivity;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


public class CustomAdapter1 extends RecyclerView.Adapter<CustomAdapter1.MyHandler> {

    public static class MyHandler extends RecyclerView.ViewHolder {

        TextView usernameTextView;
        Button viewAnimesButton;
        Button editUserButton;
        Button deleteUserButton;

        public MyHandler(@NonNull View itemView) {
            super(itemView);
            usernameTextView = itemView.findViewById(R.id.usernameTextView);
            viewAnimesButton = itemView.findViewById(R.id.viewAnimesButton);
            editUserButton = itemView.findViewById(R.id.editUserButton);
            deleteUserButton = itemView.findViewById(R.id.deleteUserButton);

        }

        public TextView getUsernameTextView() {
            return usernameTextView;
        }

        public Button getViewAnimesButton() {
            return viewAnimesButton;
        }

        public Button getEditUserButton() {
            return editUserButton;
        }

        public Button getDeleteUserButton() {
            return deleteUserButton;
        }

    }

    List<User> userList;
    public CustomAdapter1(List<User> userList) {
        this.userList = userList;
    }


    @NonNull
    @Override
    public MyHandler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View inflatedLayout = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_layout, parent, false);

        return new MyHandler(inflatedLayout);

    }


    @Override
    public void onBindViewHolder(@NonNull MyHandler holder, int position) {

        User theUser = userList.get(position);
        holder.usernameTextView.setText(theUser.getUsername());

        //If the user wants to edit their username (activity, maybe change to dialog/popup in future)
        holder.editUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent switchToEditUserActivity = new Intent(v.getContext(), EditUserActivity.class);
                switchToEditUserActivity.putExtra("oneUniqueUser", theUser.userID);
                v.getContext().startActivity(switchToEditUserActivity);
            }
        });

        //If the user wants to delete their account
        holder.deleteUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AnimeDatabase animeDb = Room.databaseBuilder(v.getContext(),
                                AnimeDatabase.class, "AnimeDB")
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries().build();

                animeDb.userDAO().deleteUser(theUser);
                userList.remove(holder.getBindingAdapterPosition());
                notifyItemRemoved(holder.getBindingAdapterPosition());
                notifyItemRangeChanged(holder.getBindingAdapterPosition(), getItemCount());

            }
        });


    }


    @Override
    public int getItemCount() {
        return userList.size();
    }


}
