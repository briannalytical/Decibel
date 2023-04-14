package com.techelevator.dao;

import com.techelevator.model.Mood;

import java.util.List;

public interface MoodDao {


    List<Mood> getMoods();
    Mood getSongName(String mood);
    List<Mood> getSongsByMoodId(int moodId);
}
