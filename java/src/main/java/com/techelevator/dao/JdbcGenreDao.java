package com.techelevator.dao;

import com.techelevator.model.Genre;
import com.techelevator.model.Mood;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcGenreDao implements GenreDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcGenreDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Genre> getGenres() {
        List<Genre> genres = new ArrayList<Genre>();
        String sql = "SELECT genre.genre_name, genre.genre_id " +
                "FROM genre ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            genres.add(mapRowToGenre(results));
        }
        return genres;
    }

    @Override
    public Genre getSongName(String genre) {
        return null;
    }

    @Override
    public List<Genre> getSongsByMoodId(int genreId) {
        return null;
    }

    private Genre mapRowToGenre(SqlRowSet row) {
        Genre genre = new Genre();
        genre.setGenre(row.getString("genre_name"));
        genre.setGenreId(row.getInt("genre_id"));
        return genre;
    }
}
