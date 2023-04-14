package com.techelevator.dao;

import com.techelevator.model.Song;

import java.util.List;

public interface SongDao {

    List<Song> playlist();

    List<Song> getSongByMood(int moodId);



    Song getSongBySongId(int songId);



    Song getSongByGenre(int genreId);

    Song addSongToList(int genreId, int moodId, int songId);
}
