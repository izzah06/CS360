package com.example.lonelytwitter;

import java.util.Date;

// is a child class of Tweet
public class ImportantTweet extends Tweet{
    public ImportantTweet(String message) {
        super(message); // super is used to call parent's constructor
    }

    public ImportantTweet(String message, Date date) {
        super(message, date);
    }

    @Override
    public Boolean isImportant() {
        return Boolean.TRUE;
    }
}
