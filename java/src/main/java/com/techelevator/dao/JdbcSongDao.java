package com.techelevator.dao;

import com.techelevator.model.Song;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcSongDao implements SongDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcSongDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Song> playlist() {
        List<Song> playlist = new ArrayList<Song>();
        String sql = "SELECT song.song_id, title, artist, genre.genre_id, genre_name " +
                "FROM song " +
                "JOIN song_genre ON song_genre.song_id = song.song_id " +
                "JOIN genre ON song_genre.genre_id = genre.genre_id ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            playlist.add(mapRowToSong(results));
        }
        return playlist;
    }

    @Override
    public Song getSongBySongId(int songId) {
        Song song = null;
        String sql = "SELECT song.song_id, title, artist " +
                "FROM song ";
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

        song.setSongId(row.getInt("song_id"));
        song.setTitle(row.getString("title"));
        song.setArtist( row.getString("artist"));
        song.setGenre(row.getString("genre_id"));
        song.setMood(row.getString("mood_id"));

        return song;
    }

}

