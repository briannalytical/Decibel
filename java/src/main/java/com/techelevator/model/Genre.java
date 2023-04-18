package com.techelevator.model;

public class Genre {

    public String genre;
    public int genreId;

    public Genre() {

    }

    public Genre(String genre, int genreId) {
        this.genre = genre;
        this.genreId = genreId;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }
}
