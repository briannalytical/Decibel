package com.techelevator.model;

public class Mood {
<<<<<<< HEAD
    public String mood;
    public int moodId;
=======
    private String mood;
    private int moodId;
>>>>>>> 631ee36001c750f95f05fb54dd9dd56e1a110cfd

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
