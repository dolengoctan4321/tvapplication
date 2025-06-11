// MovieModel.java
package com.example.tvapplication;

import java.util.ArrayList;
import java.util.List;

public class MovieModel {
    private List<Result> result;

    public MovieModel() {
        this.result = new ArrayList<>();
    }

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }

    public static class Result {
        private List<Detail> details;
        private int id;
        private String title;

        public Result() {
            this.details = new ArrayList<>();
            this.id = 0;
            this.title = "";
        }

        public List<Detail> getDetails() {
            return details;
        }

        public void setDetails(List<Detail> details) {
            this.details = details;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public static class Detail {
            private boolean adult;
            private String backdrop_path;
            private String first_air_date;
            private List<Integer> genre_ids;
            private int id;
            private String name;
            private List<String> origin_country;
            private String original_language;
            private String original_name;
            private String original_title;
            private String overview;
            private double popularity;
            private String poster_path;
            private String release_date;
            private String title;
            private boolean video;
            private double vote_average;
            private int vote_count;

            public Detail() {
                this.adult = false;
                this.backdrop_path = "";
                this.first_air_date = "";
                this.genre_ids = new ArrayList<>();
                this.id = 0;
                this.name = "";
                this.origin_country = new ArrayList<>();
                this.original_language = "";
                this.original_name = "";
                this.original_title = "";
                this.overview = "";
                this.popularity = 0.0;
                this.poster_path = "";
                this.release_date = "";
                this.title = "";
                this.video = false;
                this.vote_average = 0.0;
                this.vote_count = 0;
            }

            public boolean isAdult() { return adult; }
            public void setAdult(boolean adult) { this.adult = adult; }

            public String getBackdropPath() { return backdrop_path; }
            public void setBackdropPath(String backdropPath) { this.backdrop_path = backdropPath; }

            public String getFirstAirDate() { return first_air_date; }
            public void setFirstAirDate(String firstAirDate) { this.first_air_date = firstAirDate; }

            public List<Integer> getGenreIds() { return genre_ids; }
            public void setGenreIds(List<Integer> genreIds) { this.genre_ids = genreIds; }

            public int getId() { return id; }
            public void setId(int id) { this.id = id; }

            public String getName() { return name; }
            public void setName(String name) { this.name = name; }

            public List<String> getOriginCountry() { return origin_country; }
            public void setOriginCountry(List<String> originCountry) { this.origin_country = originCountry; }

            public String getOriginalLanguage() { return original_language; }
            public void setOriginalLanguage(String originalLanguage) { this.original_language = originalLanguage; }

            public String getOriginalName() { return original_name; }
            public void setOriginalName(String originalName) { this.original_name = originalName; }

            public String getOriginalTitle() { return original_title; }
            public void setOriginalTitle(String originalTitle) { this.original_title = originalTitle; }

            public String getOverview() { return overview; }
            public void setOverview(String overview) { this.overview = overview; }

            public double getPopularity() { return popularity; }
            public void setPopularity(double popularity) { this.popularity = popularity; }

            public String getPosterPath() { return poster_path; }
            public void setPosterPath(String posterPath) { this.poster_path = posterPath; }

            public String getReleaseDate() { return release_date; }
            public void setReleaseDate(String releaseDate) { this.release_date = releaseDate; }

            public String getTitle() { return title; }
            public void setTitle(String title) { this.title = title; }

            public boolean isVideo() { return video; }
            public void setVideo(boolean video) { this.video = video; }

            public double getVoteAverage() { return vote_average; }
            public void setVoteAverage(double voteAverage) { this.vote_average = voteAverage; }

            public int getVoteCount() { return vote_count; }
            public void setVoteCount(int voteCount) { this.vote_count = voteCount; }
        }
    }
}
