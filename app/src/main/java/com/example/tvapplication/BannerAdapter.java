package com.example.tvapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.BannerViewHolder> {

    private final List<MovieModel.Result.Detail> movieList;
    private final CategoryRowAdapter.OnMovieSelectedListener listener;

    public BannerAdapter(List<MovieModel.Result.Detail> movieList, CategoryRowAdapter.OnMovieSelectedListener listener) {
        this.movieList = movieList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public BannerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new BannerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BannerViewHolder holder, int position) {
        MovieModel.Result.Detail movie = movieList.get(position);
        String imageUrl = "https://www.themoviedb.org/t/p/w500" + movie.getPosterPath();
        Glide.with(holder.imageView.getContext()).load(imageUrl).into(holder.imageView);
        holder.itemView.setOnClickListener(v -> listener.onMovieSelected(movie));
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    static class BannerViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        BannerViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.poster_image);

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

