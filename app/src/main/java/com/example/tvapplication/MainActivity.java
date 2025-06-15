package com.example.tvapplication;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    private RecyclerView outerRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        outerRecycler = findViewById(R.id.outer_recycler);
        outerRecycler.setLayoutManager(new LinearLayoutManager(this));

        MovieViewModel viewModel = new ViewModelProvider(
                this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())
        ).get(MovieViewModel.class);

        CategoryRowAdapter adapter = new CategoryRowAdapter(this, movie -> {});
        outerRecycler.setAdapter(adapter);

        viewModel.getMovies().observe(this, movieModel -> {
            if (movieModel != null && movieModel.getResult() != null) {
                Log.d("MainActivity", "Observed movie model with " + movieModel.getResult().size() + " categories");
                adapter.setCategoryList(movieModel.getResult());
            } else {
                Log.e("MainActivity", "MovieModel null or empty");
            }
        });
    }

    private void updateDetails(MovieModel.Result.Detail item) {
//        txtTitle.setText(item.getTitle());
//        txtLanguage.setText(item.getOriginalLanguage());
//        txtOverview.setText(item.getOverview());
//
//        String imageUrl = "https://www.themoviedb.org/t/p/w780" + item.getBackdropPath();
//        Glide.with(this).load(imageUrl).into(imgBackdrop);
    }
}
