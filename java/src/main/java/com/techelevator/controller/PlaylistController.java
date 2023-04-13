package com.techelevator.controller;


import com.techelevator.dao.PlaylistDao;
import com.techelevator.model.Playlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin

public class PlaylistController {

    @Autowired
    private PlaylistDao playlistDao;



    @RequestMapping(path = "/songs/playlist/{id}", method = RequestMethod.GET)
    public List<Playlist> savedPlaylistById(@PathVariable int id) {
        return playlistDao.savedPlaylistById(id);
    }


}
