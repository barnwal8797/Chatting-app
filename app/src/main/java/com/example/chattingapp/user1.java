package com.example.chattingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class user1 extends AppCompatActivity {
    ImageView imageView;
    ImageView imageView1;
    TextView textView;
    EditText editText;
    RecyclerView recyclerView;
    List<chat_Model>chatList;


    chat_Adapter chat_adapter;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_user1);
        messageListData();
        recyclerView = findViewById(R.id.recycler_msg);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        chat_adapter = new chat_Adapter(chatList);
        recyclerView.setAdapter(chat_adapter);

        imageView1 = findViewById(R.id.img1);
        textView = findViewById(R.id.username);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        int image = intent.getIntExtra("image",0);
         textView.setText(name);
         imageView1.setImageResource(image);
        editText = findViewById(R.id.message);
        imageView = findViewById(R.id.send);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            String msg = "";
                 msg = editText.getText().toString();
                 chatList.add(new chat_Model(msg,"",true));
                 chat_adapter.notifyItemInserted(chatList.size()-1);
                 recyclerView.scrollToPosition(chatList.size()-1);
                Toast.makeText(user1.this, "send", Toast.LENGTH_SHORT).show();
            editText.getText().clear();

            }
        });
        imageView = findViewById(R.id.attachment);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("*/*");
                Intent i = Intent.createChooser(intent, "File");
                int CHOOSE_FILE_REQUESTCODE =0;
                startActivityForResult(i, CHOOSE_FILE_REQUESTCODE);
            }
        });

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                imageView = findViewById(R.id.send);
                imageView.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String text = editText.getText().toString();
                if (text.length()>0){
                    imageView = findViewById(R.id.send);
                    imageView.setVisibility(View.VISIBLE);
                } else {
                    imageView = findViewById(R.id.send);
                    imageView.setVisibility(View.INVISIBLE);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
                String text = editText.getText().toString();
                if (text.length()>0){
                    imageView = findViewById(R.id.send);
                    imageView.setVisibility(View.VISIBLE);
                } else {
                    imageView = findViewById(R.id.send);
                    imageView.setVisibility(View.INVISIBLE);
                }
            }
        });
        imageView = findViewById(R.id.backbutton);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(user1.this,chatting.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });
    }
    public void messageListData() {
        chatList = new ArrayList<>();

        chatList.add(new chat_Model(" You're trading off programmer convenience for a tiny performance hit.","11:10:00",true));
        chatList.add(new chat_Model(" You're trading off programmer convenience for a tiny performance hit.","11:10am",true));
        chatList.add(new chat_Model(" You're trading off programmer convenience for a tiny performance hit.","11:10am",false));
        chatList.add(new chat_Model(" You're trading off programmer convenience for a tiny performance hit.","11:10am",false));
//        chatList.add(new chat_Model(" You're trading off programmer convenience for a tiny performance hit.","11:10am","",""));
//        chatList.add(new chat_Model(" You're trading off programmer convenience for a tiny performance hit.","11:10am","",""));
//        chatList.add(new chat_Model(" You're trading off programmer convenience for a tiny performance hit.","11:10am","",""));
//        chatList.add(new chat_Model(" You're trading off programmer convenience for a tiny performance hit.","11:10am","",""));
    }
}