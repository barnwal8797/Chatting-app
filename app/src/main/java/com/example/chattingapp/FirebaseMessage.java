package com.example.chattingapp;

import android.nfc.Tag;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import javax.net.ssl.KeyManager;

public class FirebaseMessage extends FirebaseMessagingService {

    @Override
    public void onNewToken(String token) {
        super.onNewToken(token);
//        sendTokenToServer(token);
        Log.d("get_newToken", "newToken:" +token);

    }

    @Override
    public void onMessageReceived(@NonNull RemoteMessage message) {
        super.onMessageReceived(message);
        Log.d("get_token","newToken" + message.getFrom());
        if (message.getData().size()>0){
            Log.d("get_token","newToken" + message.getData());

        }
    }
}
