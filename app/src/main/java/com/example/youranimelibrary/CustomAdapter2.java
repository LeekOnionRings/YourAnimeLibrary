package com.example.youranimelibrary;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class CustomAdapter2 extends RecyclerView.Adapter<CustomAdapter2.MyHandler> {

    TextView animeNameTextView;
    TextView animeGenreTextView;
    Button animeFavoriteStarButton;
    TextView animeToWatchTextView; //clickable
    TextView animeRatingTextView;

    public static class MyHandler extends RecyclerView.ViewHolder {
        public MyHandler(@NonNull View itemView) {
            super(itemView);
        }
    }

    @NonNull
    @Override
    public CustomAdapter2.MyHandler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter2.MyHandler holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


}
