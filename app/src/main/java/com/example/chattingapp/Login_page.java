package com.example.chattingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
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

public class Login_page extends AppCompatActivity {
Button Log_in;
EditText email, password;
FirebaseAuth mAuth;
TextView Sign_up;
    @SuppressLint("MissingInflatedId")
    @Override
 protected void onCreate(Bundle savedInstanceState) {
   super.onCreate(savedInstanceState);
   requestWindowFeature(Window.FEATURE_NO_TITLE);
getSupportActionBar().hide();
    setContentView(R.layout.activity_login_page);
    email = findViewById(R.id.email);
    password = findViewById(R.id.psd);
    mAuth = FirebaseAuth.getInstance();
     Log_in = findViewById(R.id.log_in);

   Log_in.setOnClickListener(new View.OnClickListener() {
         @Override
      public void onClick(View view) {
         String Email = email.getText().toString();
         String Password = password.getText().toString();


if (Email.isEmpty()){
    email.setError("enter user id");
    email.requestFocus();
    return;
}
if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
    email.requestFocus();
    return;
}
if (Password.isEmpty()){
    password.setError("enter password");
    password.requestFocus();
    return;
}
//if (!Password.matches("password")){
//    password.setError("enter valid password");
//    password.requestFocus();
//    return;
//}


mAuth.signInWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {
        if (task.isSuccessful()){
            Toast.makeText(Login_page.this, "logged in", Toast.LENGTH_SHORT).show();
         String uid = FirebaseAuth.getInstance().getUid();
          Log.i("Log_in","Log_in");

    SharedPreferences pref = getSharedPreferences("Login",MODE_PRIVATE);
    SharedPreferences.Editor editor = pref.edit();
    editor.putString("email",Email);
    editor.putString("uid",uid);
//    editor.commit();
    editor.apply();

        Intent intent = new Intent(Login_page.this,chatting.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
        }else {
            Toast.makeText(Login_page.this, "user not found", Toast.LENGTH_SHORT).show();
        }
    }

});
         }
   });
//        SharedPreferences share_pref = getSharedPreferences("Login",MODE_PRIVATE);
//        Boolean check = share_pref.getBoolean("flag",false);
//        Intent nextActivity;
//        if (check){
//            nextActivity = new Intent(Login_page.this,MainActivity.class);
//
//        }else{
//            nextActivity = new Intent(Login_page.this,Create_account.class);
//        }
//        startActivity(nextActivity);
//SharedPreferences share_pref = getSharedPreferences("Login",MODE_PRIVATE);
//SharedPreferences.Editor editor = share_pref.edit();
//    editor.putString("Email",Email);
//    editor.putString("Password",Password);
//    editor.apply();

//   SharedPreferences get_pref = getSharedPreferences("Login",MODE_PRIVATE);
//   String value =  get_pref.getString("Email","false");

   
     Sign_up = findViewById(R.id.go_to_signup);
     Sign_up.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Intent intent = new Intent(Login_page.this,Create_account.class);
             intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
             startActivity(intent);
             finish();
         }
     });

    }
}