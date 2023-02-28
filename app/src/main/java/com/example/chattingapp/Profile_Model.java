package com.example.chattingapp;

public class Profile_Model {

    private int ImageView;
    private String TextView;

    public Profile_Model(int imageView, String textView) {
        ImageView = imageView;
        TextView = textView;
    }

    public int getImageView() {
        return ImageView;
    }

    public String getTextView() {
        return TextView;
    }
}
