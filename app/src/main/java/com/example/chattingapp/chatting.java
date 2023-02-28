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
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.ArrayList;
import java.util.List;
public class chatting extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Model> userList;
    Adapter adapter;
    List<Profile_Model>profileList;
    profile_Adapter profile_adapter;
    ImageView imageView;
    Button logOut;
    CardView cardView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                String token = task.getResult();
                Log.d("get_newToken","newToken");
//                Toast.makeText(MainActivity.this, "Token_generated", Toast.LENGTH_SHORT).show();
            }
        });
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_chatting);
        linearListData();
        recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new Adapter(userList);
        recyclerView.setAdapter(adapter);
        userListData();
        recyclerView = findViewById(R.id.recycler_img);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        profile_adapter = new profile_Adapter(profileList);
        recyclerView.setAdapter(profile_adapter);
        logOut = findViewById(R.id.log_out);
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharePref = getSharedPreferences("Login",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharePref.edit().clear();
                String uid = sharePref.getString("uid","user");
                String email = sharePref.getString("email","Email");

                editor.remove("email");
                editor.remove("uid");
                editor.commit();
                editor.apply();
                Intent intent = new Intent(chatting.this,MainActivity.class);

                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();
            }
        });
        imageView = findViewById(R.id.Dp);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chatting.this,Setting.class);
                startActivity(intent);
                finish();
            }
        });
    }
    private void userListData() {
        profileList = new ArrayList<>();
        profileList.add(new Profile_Model(R.drawable.pic,"Me"));
        profileList.add(new Profile_Model(R.drawable.img1,"Nakul"));
        profileList.add(new Profile_Model(R.drawable.img2,"Anika"));
        profileList.add(new Profile_Model(R.drawable.img3,"Azazul"));
        profileList.add(new Profile_Model(R.drawable.img4,"Nidhi"));
        profileList.add(new Profile_Model(R.drawable.img5,"Niraj"));
        profileList.add(new Profile_Model(R.drawable.img6,"Mohan"));
        profileList.add(new Profile_Model(R.drawable.img7,"Rahul"));
        profileList.add(new Profile_Model(R.drawable.img8,"Naqueeb"));
        profileList.add(new Profile_Model(R.drawable.img9,"Divya"));
        profileList.add(new Profile_Model(R.drawable.img10,"Roshan"));
    }
    private void linearListData() {
        userList = new ArrayList<>();

        userList.add(new Model(R.drawable.img1,"Nakul","This tool is completely free","11:10am"));
        userList.add(new Model(R.drawable.img2,"Anika","This tool is completely free","10:35am"));
        userList.add(new Model(R.drawable.img3,"Azazul","This tool is completely free","10:20am"));
        userList.add(new Model(R.drawable.img4,"Nidhi","This tool is completely free","11:10am"));
        userList.add(new Model(R.drawable.img5,"Niraj","This tool is completely free","10:35am"));
        userList.add(new Model(R.drawable.img6,"Mohan","This tool is completely free","10:20am"));
        userList.add(new Model(R.drawable.img7,"Rahul","This tool is completely free","11:10am"));
        userList.add(new Model(R.drawable.img8,"Naqueeb","This tool is completely free","10:35am"));
        userList.add(new Model(R.drawable.img9,"Divya","This tool is completely free","10:20am"));
        userList.add(new Model(R.drawable.img10,"Roshan","This tool is completely free","10:20am"));
    }

}