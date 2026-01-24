package com.example.lonelytwitter;

import java.util.Date;

public abstract class Tweet implements Tweetable{
//    make attributes
    private Date date;  //type name
    private String message;

    public Tweet(String message) {
        this.message = message;
    }
    public Tweet(String message, Date date) {
        this.message = message;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public abstract Boolean isImportant();
}
