package com.example.chattingapp;

public class Model {

   private int imageview;
   private String textview;
   private String textview2;
   private String textview3;

    public Model(int imageview, String textview, String textview2, String textview3) {
        this.imageview = imageview;
        this.textview = textview;
        this.textview2 = textview2;
        this.textview3 = textview3;
    }

    public int getImageview() {
        return imageview;
    }

    public String getTextview() {
        return textview;
    }

    public String getTextview2() {
        return textview2;
    }

    public String getTextview3() {
        return textview3;
    }
}
