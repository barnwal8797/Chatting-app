package com.example.chattingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Window;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

     new Handler().postDelayed(new Runnable() {
       @Override
       public void run() {

           SharedPreferences pref = getSharedPreferences("Login",MODE_PRIVATE);
           String uid = pref.getString("uid","user");
           String email = pref.getString("email","Email");
           Log.i("Log_in","Log_in");

        if (!uid.equals("user")){
            String user = FirebaseAuth.getInstance().getUid();
            if (user!="null"){
                Intent intent = new Intent(MainActivity.this,chatting.class);
                startActivity(intent);
                finish();
            }else{
                Intent i = new Intent(MainActivity.this,Login_page.class);
                startActivity(i);
                finish();
            }

//        Intent intent = new Intent(MainActivity.this,chatting.class);
//        startActivity(intent);
//        finish();
           }
           else{
        Intent iNext = new Intent(MainActivity.this,Login_page.class);
        startActivity(iNext);
        finish();
           }
//           editor.putString("email","Email");
//           editor.putString("user","uid");
//           SharedPreferences sharePref = getSharedPreferences("Login",MODE_PRIVATE);
//           Boolean check = sharePref.getBoolean("flag",false);
//    Intent intent = new Intent(MainActivity.this,Login_page.class);
//startActivity(intent);
//finish();

//           if (true){
//        Intent intent = new Intent(MainActivity.this,chatting.class);
//        startActivity(intent);
//        finish();
//           }
//           else{
//        Intent iNext = new Intent(MainActivity.this,Login_page.class);
//        startActivity(iNext);
//        finish();
//           }
         }
      },6000);

    }




}
