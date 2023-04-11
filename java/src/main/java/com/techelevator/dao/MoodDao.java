package com.techelevator.dao;

import com.techelevator.model.Mood;

import java.util.List;

public interface MoodDao {


    List<Mood> getSongsByMood(int moodId);
    Mood getSongName(String mood);
    Mood getMoodById(int moodId);
}
