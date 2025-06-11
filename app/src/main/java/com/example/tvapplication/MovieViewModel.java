package com.example.tvapplication;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class MovieViewModel extends AndroidViewModel {
    private final MutableLiveData<MovieModel> movies = new MutableLiveData<>();

    public MovieViewModel(@NonNull Application application) {
        super(application);
        loadMovies();
    }

    public LiveData<MovieModel> getMovies() {
        return movies;
    }

    private void loadMovies() {
        try {
            InputStream is = getApplication().getAssets().open("movies.json");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            MovieModel model = new Gson().fromJson(reader, MovieModel.class);
            Log.d("MovieViewModel", "Parsed movieModel: " + model.getResult().size());
            movies.postValue(model);
        } catch (Exception e) {
            Log.e("MovieViewModel", "Failed to load JSON", e);
        }
    }
}

