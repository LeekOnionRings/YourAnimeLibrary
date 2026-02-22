package com.example.youranimelibrary;

import static androidx.core.content.ContextCompat.startActivity;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.widget.TextView;
import android.view.View;
import android.view.ViewGroup;



public class CustomAdapter1 extends RecyclerView.Adapter<CustomAdapter1.MyHandler> {

    public static class MyHandler extends RecyclerView.ViewHolder {

        public MyHandler(@NonNull View itemView) {
            super(itemView);
        }
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
        return 0;
    }


}
