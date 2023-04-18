package com.techelevator.model;
import com.techelevator.model.Song;

import java.util.List;

public class Playlist {

    public String playlistName;
    public int playlistId;
    public List<Song> songs;
    public String playlistPicture;

    public String getPlaylistPicture() {
        return playlistPicture;
    }

    public void setPlaylistPicture(String playlistPicture) {
        this.playlistPicture = playlistPicture;
    }

    public Playlist() {

    }

    public Playlist(String playlistName, int playlistId){
        this.playlistName = playlistName;
        this.playlistId = playlistId;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
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

}


