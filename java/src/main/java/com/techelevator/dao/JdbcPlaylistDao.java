package com.techelevator.dao;
import com.techelevator.model.Playlist;
import com.techelevator.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component

public class JdbcPlaylistDao implements PlaylistDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcPlaylistDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);

    }


    @Override
    public List<Playlist> savedPlaylistById(int playlistId) {
        List<Playlist> savedPlaylist = new ArrayList<Playlist>();
        String sql = "SELECT playlist.playlist_id, playlist_name, users.user_id, username " +
                "FROM playlist " +
                "JOIN playlist_users ON playlist_users.playlist_id = playlist.playlist_id " +
                "JOIN users ON playlist_users.user_id = users.user_id " +
                "WHERE users.user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, playlistId);
        while(results.next()) {
            savedPlaylist.add(mapRowToPlaylist(results));
        }


        return savedPlaylist;
    }

    private Playlist mapRowToPlaylist(SqlRowSet row) {
        Playlist playlist = new Playlist();
        User user = new User();
        user.setId(row.getInt("user_id"));
        user.setUsername(row.getString("username"));
        playlist.setPlaylistName(row.getString("playlist_name"));
        playlist.setPlaylistId(row.getInt("playlist_id"));


        return playlist;

    }
}
