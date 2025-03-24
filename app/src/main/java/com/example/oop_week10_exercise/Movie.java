package com.example.oop_week10_exercise;

public class Movie {
    private String title;
    private int year;
    private String genre;
    private int posterResourceId;

    // Constructor with validation
    public Movie(String title, int year, String genre, int posterResourceId) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        if (year < 1888) { // First film was made in 1888
            throw new IllegalArgumentException("Invalid year");
        }
        if (genre == null || genre.isEmpty()) {
            throw new IllegalArgumentException("Genre cannot be empty");
        }
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.posterResourceId = posterResourceId;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year < 1888) {
            throw new IllegalArgumentException("Invalid year");
        }
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        if (genre == null || genre.isEmpty()) {
            throw new IllegalArgumentException("Genre cannot be empty");
        }
        this.genre = genre;
    }

    public int getPosterResourceId() {
        return posterResourceId;
    }

    public void setPosterResourceId(int posterResourceId) {
        this.posterResourceId = posterResourceId;
    }
}
