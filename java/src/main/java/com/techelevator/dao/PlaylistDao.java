package com.techelevator.dao;

import com.techelevator.model.Playlist;

import java.util.List;

public interface PlaylistDao {

    public List <Playlist> getSongsInPlaylist(int userId);

    public void savePlaylist(Playlist playlist, int userId);



    public void deletePlayListById(String playlistName, int userId);

    public void updatePlaylist(String playlistPicture, String playlistName, int playlistId);


}
