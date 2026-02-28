package com.example.youranimelibrary;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class CustomAdapter2 extends RecyclerView.Adapter<CustomAdapter2.MyHandler> {

    public static class MyHandler extends RecyclerView.ViewHolder {

        TextView animeNameTextView;
        TextView animeGenreTextView;
        ImageButton animeFavoriteStarButton;
        TextView animeToWatchTextView; //clickable?
        TextView animeRatingTextView;
        Button editAnimeButton;
        Button deleteAnimeButton;
        public MyHandler(@NonNull View itemView) {
            super(itemView);
            animeNameTextView = itemView.findViewById(R.id.animeNameTextView);
            animeGenreTextView = itemView.findViewById(R.id.animeGenreTextView);
            animeFavoriteStarButton = itemView.findViewById(R.id.animeFavoriteStarButton);
            animeToWatchTextView = itemView.findViewById(R.id.animeToWatchTextView);
            animeRatingTextView = itemView.findViewById(R.id.animeRatingTextView);
            editAnimeButton = itemView.findViewById(R.id.editAnimeButton);
            deleteAnimeButton = itemView.findViewById(R.id.deleteAnimeButton);

        }

        public TextView getAnimeNameTextView() {
            return animeNameTextView;
        }

        public TextView getAnimeGenreTextView() {
            return animeGenreTextView;
        }

        public ImageButton getAnimeFavoriteStarButton() {
            return animeFavoriteStarButton;
        }

        public TextView getAnimeToWatchTextView() {
            return animeToWatchTextView;
        }

        public TextView getAnimeRatingTextView() {
            return animeRatingTextView;
        }

        public Button getEditAnimeButton() {
            return editAnimeButton;
        }

        public Button getDeleteAnimeButton() {
            return deleteAnimeButton;
        }

    }

    List<Anime> animeList;
    public CustomAdapter2(List<Anime> animeList) {
        this.animeList = animeList;
    }

    @NonNull
    @Override
    public CustomAdapter2.MyHandler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflatedLayout = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.anime_layout, parent, false);

        return new CustomAdapter2.MyHandler(inflatedLayout);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter2.MyHandler holder, int position) {

        Anime theAnime = animeList.get(position);
        holder.animeNameTextView.setText(theAnime.getAnimeName());
        holder.animeGenreTextView.setText(theAnime.getAnimeGenre());

        //To be added

    }

    @Override
    public int getItemCount() {
        return animeList.size();
    }


}
