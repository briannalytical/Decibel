package com.techelevator.dao;

import com.techelevator.model.Playlist;

import java.util.List;

public interface PlaylistDao {

    public List<Playlist> getSongsInPlaylist(int userId);

    public void savePlaylist(Playlist playlist, int userId);

    public void deletePlaylistById(String playlistName, int userId);

    public void updatePlaylist(Playlist playlist);
<<<<<<< HEAD
}
=======

}
>>>>>>> 4e5a60efc7b73a8cd0a24439b74a5c5d093384dd
