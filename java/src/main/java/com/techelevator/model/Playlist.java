package com.techelevator.model;
import com.techelevator.model.Song;

import java.util.List;

public class Playlist {

    public String playlistName;
    public int playlistId;
    public List<Song> songs;
<<<<<<< HEAD

    public String getPlaylistImage() {
        return playlistImage;
    }

    public void setPlaylistImage(String playlistImage) {
        this.playlistImage = playlistImage;
    }
=======
    public String playlistImage;
>>>>>>> 4e5a60efc7b73a8cd0a24439b74a5c5d093384dd

    public String playlistImage;



    public Playlist() {

    }

    public Playlist(String playlistName, int playlistId, String playlistImage){
        this.playlistName = playlistName;
        this.playlistId = playlistId;
        this.playlistImage = playlistImage;
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

    public String getPlaylistImage() {
        return playlistImage;
    }

    public void setPlaylistImage(String playlistImage) {
        this.playlistImage = playlistImage;
    }

}


