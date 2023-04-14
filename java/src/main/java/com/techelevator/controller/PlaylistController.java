package com.techelevator.controller;


import com.techelevator.dao.PlaylistDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Playlist;
import com.techelevator.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
@PreAuthorize("isAuthenticated()")
@RestController
@CrossOrigin
public class PlaylistController {

    @Autowired
    private PlaylistDao playlistDao;

    @Autowired
    private UserDao userDao;

    @RequestMapping(path = "/playlist", method = RequestMethod.GET)
    public List <Playlist> getSongsInPlaylist(Principal user) {
        return playlistDao.getSongsInPlaylist(userDao.findIdByUsername(user.getName()));
    }

    @RequestMapping(path = "/playlist", method = RequestMethod.POST)
    public List <Playlist> savePlaylist(@RequestBody List<Song> playlist, Principal user) {
//        return playlistDao.getSongsInPlaylist(userDao.findIdByUsername(user.getName()));
        return new ArrayList<>();
  }
}
