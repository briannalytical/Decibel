package com.techelevator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.techelevator.dao.MoodDao;
import com.techelevator.model.Mood;

import java.util.List;

@RestController
@CrossOrigin
public class MoodController {

    @Autowired
    private MoodDao moodDao;

//    public MoodController(MoodDao moodDao) {
//        this.moodDao = moodDao;
//    }

    @RequestMapping(path = "/moods/{id}", method = RequestMethod.GET)
    public List<Mood> getSongsByMood(@PathVariable int id) {
        return moodDao.getSongsByMood(id);
    }

}
