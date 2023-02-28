package com.example.chattingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class Setting extends AppCompatActivity {
    TextView logOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
//        logOut.findViewById(R.id.log_out);
//        logOut.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SharedPreferences sharePref = getSharedPreferences("Login",MODE_PRIVATE);
//                SharedPreferences.Editor editor = sharePref.edit();
//
//                editor.putBoolean("flag",false);
//                editor.apply();
//            }
//        });
    }
}