package com.techelevator.model;

public class Playlist {

    public String playlistName;
    public int playlistId;


    public Playlist() {
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public int getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(int playlistId) {
        this.playlistId = playlistId;
    }

    public Playlist(String playlistName, int playlistId){
        this.playlistName = playlistName;
        this.playlistId = playlistId;
    }
}


