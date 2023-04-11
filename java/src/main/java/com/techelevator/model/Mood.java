package com.techelevator.model;

public class Mood {

    public String mood;
    public int moodId;




    public Mood(){

}

    public Mood(String mood, int moodId) {
        this.mood = mood;
        this.moodId = moodId;
    }


    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public int getMoodId() {
        return moodId;
    }

    public void setMoodId(int moodId) {
        this.moodId = moodId;
    }


}
