package com.example.tvapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RankedAdapter extends RecyclerView.Adapter<RankedAdapter.RankedViewHolder> {

    private final List<MovieModel.Result.Detail> movieList;
    private final CategoryRowAdapter.OnMovieSelectedListener listener;

    public RankedAdapter(List<MovieModel.Result.Detail> movieList, CategoryRowAdapter.OnMovieSelectedListener listener) {
        this.movieList = movieList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RankedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_ranked, parent, false);
        return new RankedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RankedViewHolder holder, int position) {
        MovieModel.Result.Detail movie = movieList.get(position);
        String imageUrl = "https://www.themoviedb.org/t/p/w500" + movie.getPosterPath();
        Glide.with(holder.imageView.getContext()).load(imageUrl).into(holder.imageView);
        holder.rankText.setText(String.valueOf(position + 1));
        holder.itemView.setOnClickListener(v -> listener.onMovieSelected(movie));
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    static class RankedViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView rankText;

        RankedViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.poster_image);
            rankText = itemView.findViewById(R.id.rank_number);

            itemView.setOnFocusChangeListener((v, hasFocus) -> {
                if (hasFocus) {
                    v.bringToFront();
                    v.animate().scaleX(1.1f).scaleY(1.1f).setDuration(200).start();
                    v.setBackgroundResource(R.drawable.item_background_focused);
                } else {
                    v.animate().scaleX(1f).scaleY(1f).setDuration(200).start();
                    v.setBackgroundResource(R.drawable.item_background_normal);
                }
            });
        }
    }
}

