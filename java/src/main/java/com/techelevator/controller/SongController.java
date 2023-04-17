package com.techelevator.controller;

import com.techelevator.dao.SongDao;
import com.techelevator.model.Song;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class SongController {

    private SongDao songDao;

    public SongController(SongDao songDao) {
        this.songDao = songDao;
    }

    @RequestMapping(path = "/songs", method = RequestMethod.GET)
    public List<Song> playlist() {
        return songDao.playlist();
    }

    @RequestMapping(path = "/songs/moods/{id}", method = RequestMethod.GET)
    public List<Song> getSongByMood(@PathVariable int id) {
        return songDao.getSongByMood(id);
    }

//    @RequestMapping(path="/songs/genres{id}", method=RequestMethod.GET)
//    public List<Song> getSongByGenre(@PathVariable int id) {
//        return songDao.getSongByGenre(id);
//    }




}


