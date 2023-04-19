package com.techelevator.dao;

import com.techelevator.model.Playlist;

import java.util.List;

public interface PlaylistDao {

    List <Playlist> getSongsInPlaylist(int userId);

    void savePlaylist(Playlist playlist, int userId);

    void deletePlaylistById(String playlistName, int userId);

    void updatePlaylist(Playlist playlist);

    Playlist getPlaylistImageByUserId (int playlistId);

}
