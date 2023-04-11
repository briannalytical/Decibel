package com.techelevator.dao;

import com.techelevator.model.Mood;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class JdbcMoodDao implements MoodDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcMoodDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Mood> getMoods() {
        List<Mood> getMood = new ArrayList<Mood>();
        String sql= "SELECT song.song_id, title, artist, mood_name, mood.mood_id, genre.genre_id " +
                "FROM song " +
                "JOIN song_mood ON song_mood.song_id =song.song_id " +
                "JOIN mood ON song_mood.mood_id = mood.mood_id " +
                "JOIN song_genre ON song_genre.song_id = song.song_id " +
                "JOIN genre ON song_genre.genre_id = genre.genre_id ";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            getMood.add(mapRowToMood(results));
        }
        return getMood;
    }





    @Override
    public Mood getSongName(String mood) {
        return null;
    }

    @Override
    public List<Mood> getSongsByMoodId(int moodId) {
        return null;
    }


    private Mood mapRowToMood(SqlRowSet row) {
        Mood mood = new Mood();
        mood.setMood(row.getString("mood_name"));
        mood.setMoodId(row.getInt("mood_id"));


        return mood;
    }

}
