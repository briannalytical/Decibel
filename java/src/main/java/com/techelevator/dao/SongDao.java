package com.techelevator.dao;

import com.techelevator.model.Song;

import java.util.List;

public interface SongDao {

    List<Song> songs();

    Song getSong(int songId);

    Song addSongToList(int genreId, int moodId, int songId);

    
}
