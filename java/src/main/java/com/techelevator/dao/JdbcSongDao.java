package com.techelevator.dao;
import com.techelevator.model.Playlist;
import com.techelevator.model.Song;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcSongDao implements SongDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcSongDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);

    }

    public List<Song> playlist() {
        List<Song> playlist = new ArrayList<Song>();
        String sql = "SELECT song.song_id, title, artist, genre.genre_id, genre_name, mood_name, mood.mood_id " +
                "FROM song " +
                "JOIN song_genre ON song_genre.song_id = song.song_id " +
                "JOIN genre ON song_genre.genre_id = genre.genre_id " +
                "JOIN song_mood ON song_mood.song_id =song.song_id " +
                "JOIN mood ON song_mood.mood_id = mood.mood_id ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            playlist.add(mapRowToSong(results));
        }
        return playlist;
    }
@Override
  public List<Song> getSongByMood(int moodId) {
   List<Song> getSongByMoodList = new ArrayList<Song>();
       String sql = "SELECT genre_name, song.song_id, title, artist, mood_name, mood.mood_id, genre.genre_id " +
               "FROM song " +
               "JOIN song_mood ON song_mood.song_id =song.song_id " +
               "JOIN mood ON song_mood.mood_id = mood.mood_id " +
               "JOIN song_genre ON song_genre.song_id = song.song_id " +
               "JOIN genre ON song_genre.genre_id = genre.genre_id " +
               "WHERE mood.mood_id =?";
       SqlRowSet results = jdbcTemplate.queryForRowSet(sql, moodId);
      while (results.next()) {
          getSongByMoodList.add(mapRowToSong(results));
       }
      return getSongByMoodList;
  }




    @Override
    public Song getSongBySongId(int songId) {

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
        song.setGenre(row.getString("genre_name"));
        song.setMood(row.getString("mood_name"));
        song.setTitle(row.getString("title"));
        song.setMoodId(row.getInt("mood_id"));
        song.setSongId(row.getInt("song_id"));


        return song;
    }
}