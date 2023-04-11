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

    @RequestMapping(path = "songs/moods", method = RequestMethod.GET)
    public List<Mood> getMoods() {
        return moodDao.getMoods();
    }

}
