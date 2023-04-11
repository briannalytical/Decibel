package com.techelevator.model;

public class Song {

    public String title;
    public String artist;
    public String genre;
    public int songId;
    public String mood;
    public int moodId;



    public int getMoodId() {
        return moodId;
    }

    public void setMoodId(int moodId) {
        this.moodId = moodId;
    }

    public Song() {

    }

    public Song(String title, String artist, String genre, int songId, String mood) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.songId = songId;
        this.mood = mood;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getsongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }
}
