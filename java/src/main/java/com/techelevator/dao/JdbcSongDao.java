package com.techelevator.dao;

import com.techelevator.model.Song;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcSongDao implements SongDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcSongDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);

    }

    @Override
    public Song getSongBySongId(int songId) {
        return null;
    }

    @Override
    public Song getSongByMood(int moodId) {
        return null;
    }

    @Override
    public Song getSongByGenre(int genreId) {
        return null;
    }

    @Override
    public Song addSongToList(int genreId, int moodId, int songId) {
        return null;
    }

    //mapping method
    private Song mapRowToSong(SqlRowSet row) {
        Song song = new Song();

        song.setArtist( row.getString("artist"));
        song.setGenre(row.getString("genre"));
        song.setMood(row.getString("mood_name"));
        song.setTitle(row.getString("title"));
        song.setSongId(row.getInt("song_id"));

        return song;
    }
}
