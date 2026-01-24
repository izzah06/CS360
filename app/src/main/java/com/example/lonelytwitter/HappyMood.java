package com.example.lonelytwitter;

import java.util.Date;

public class HappyMood extends Mood {
    public HappyMood() {
    }

    public HappyMood(Date date) {
        super(date);
    }

    @Override
    public Boolean isHappy() {
        return Boolean.TRUE;
    }

    @Override
    public String getMoodString() {
        return "Happy";
    }
}
