package com.techelevator.dao;

import com.techelevator.model.Playlist;

import java.util.List;

public interface PlaylistDao {

    List<Playlist> savedPlaylistById(int playlistId);


}
