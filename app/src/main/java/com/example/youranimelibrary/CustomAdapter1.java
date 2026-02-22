package com.example.youranimelibrary;

import static androidx.core.content.ContextCompat.startActivity;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
        return null;
    }


    @Override
    public void onBindViewHolder(@NonNull MyHandler holder, int position) {

    }


    @Override
    public int getItemCount() {
        return userList.size();
    }


}
