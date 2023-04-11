package com.techelevator.dao;

import com.techelevator.model.Mood;
import com.techelevator.model.Song;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcMoodDao implements MoodDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcMoodDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Mood> getSongsByMood(int moodId) {
        List<Mood> songsByMood = new ArrayList<Mood>();
        String sql= "SELECT song.song_id, title, artist, mood_name, mood.mood_id, genre.genre_id\n" +
                "FROM song" +
                "JOIN song_mood ON song_mood.song_id =song.song_id" +
                "JOIN mood ON song_mood.mood_id = mood.mood_id" +
                "JOIN song_genre ON song_genre.song_id = song.song_id " +
                "JOIN genre ON song_genre.genre_id = genre.genre_id " +
                "WHERE mood.mood_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, moodId);
        while(results.next()) {
            songsByMood.add(mapRowToMood(results));
        }
        return songsByMood;
    }





    @Override
    public Mood getSongName(String mood) {
        return null;
    }

    @Override
    public Mood getMoodById(int moodId) {
        return null;
    }


    private Mood mapRowToMood(SqlRowSet row) {
        Mood mood = new Mood();
        mood.setMood(row.getString("mood_name"));
        mood.setMoodId(row.getInt("mood_id"));


        return mood;
    }

}
