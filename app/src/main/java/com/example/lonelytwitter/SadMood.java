package com.example.lonelytwitter;

import java.util.Date;

public class SadMood extends Mood{
    public SadMood() {
    }

    public SadMood(Date date) {
        super(date);
    }

    @Override
    public Boolean isHappy() {
        return Boolean.FALSE;
    }

    @Override
    public String getMoodString() {
        return "Sad";
    }
}
