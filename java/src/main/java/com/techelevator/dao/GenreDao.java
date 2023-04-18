package com.techelevator.dao;

import com.techelevator.model.Genre;

import java.util.List;

public interface GenreDao {

    List<Genre> getGenres();

    Genre getSongName(String genre);

    List<Genre> getSongsByMoodId(int genreId);

}
