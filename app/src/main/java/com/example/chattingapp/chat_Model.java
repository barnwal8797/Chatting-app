package com.example.chattingapp;

import java.util.Date;

public class chat_Model {
    private String message;
    private Date sentAt;
    boolean isMe;

    public chat_Model(String message, String sentAt, boolean isMe) {
        this.message = message;
        this.sentAt = new Date();
        this.isMe = isMe;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getSentAt() {
        return sentAt;
    }

    public void setSentAt(String sentAt) {
        this.sentAt = new Date(sentAt);
    }

    public boolean isMe() {
        return isMe;
    }

    public void setMe(boolean me) {
        isMe = me;
    }
}








