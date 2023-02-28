package com.example.chattingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.regex.Pattern;

public class Create_account extends AppCompatActivity {
    TextView Sign_in;
    Button button;
    EditText name, email, phone_no, password;
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    String work;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);

      requestWindowFeature(Window.FEATURE_NO_TITLE);
      getSupportActionBar().hide();
      setContentView(R.layout.activity_create_account);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        phone_no = findViewById(R.id.ph_no);
        password = findViewById(R.id.psd);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

      Sign_in =findViewById(R.id.sign_in);
      Sign_in.setOnClickListener(new View.OnClickListener() {
         @Override
      public void onClick(View view) {
      Intent intent = new Intent(Create_account.this,Login_page.class);
      intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
      startActivity(intent);
       finish();
        }
      });
      button = findViewById(R.id.sign_up);
      button.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
    String Name = name.getText().toString();
    String Email = email.getText().toString();
    String Phone_Number = phone_no.getText().toString();
    String Password = password.getText().toString();

    if (Name.isEmpty()){
        name.setError("please enter Name");
        name.requestFocus();
        return;
    }
    if (Email.isEmpty()){
        email.setError("enter your Email");
        email.requestFocus();
        return;
    }
    if (Email.matches("email")){
        email.setError("Already taken");
        email.requestFocus();
        return;
    }
    if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches()){
        email.setError("xyz@gmail.com");
        email.requestFocus();
        return;
    }
    if (Phone_Number.isEmpty()){
        phone_no.setError("enter your phone no.");
        phone_no.requestFocus();
        return;
    }
    if (!(Phone_Number.length() ==10)){
        phone_no.setError("enter correct no.");
        phone_no.requestFocus();
        return;
    }
    if (Phone_Number.matches("phone_no")){
        phone_no.setError("user already registered");
        phone_no.requestFocus();
        return;
    }
    if (Password.isEmpty()){
        password.setError("enter password");
        password.requestFocus();
        return;
    }
    if (Password.length()<6){
        password.setError("password length must be more than 6digit");
        password.requestFocus();
        return;
    }

mAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {
       if (task.isSuccessful()){
           Toast.makeText(Create_account.this, "successfully registered", Toast.LENGTH_SHORT).show();
           Intent intent = new Intent(Create_account.this,Login_page.class);
           startActivity(intent);

       } else{
           Toast.makeText(Create_account.this, "Enter correct details", Toast.LENGTH_SHORT).show();
       }
    }
});
          }
      });
    }
}