package com.example.chattingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public static void main(String[] args) {
        int x = 0;
      for (x=0;x<=5;x++){
          System.out.println(x);
          Log.d("x","x");
      }

    }
}
