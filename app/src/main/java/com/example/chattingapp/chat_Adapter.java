package com.example.chattingapp;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class chat_Adapter extends RecyclerView.Adapter<chat_Adapter.ViewHolder> {

   private List<chat_Model>chatList;

   public chat_Adapter (List<chat_Model>chatList){this.chatList = chatList;}

    @NonNull
    @Override
    public chat_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_view,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull chat_Adapter.ViewHolder holder, int position) {
        Date date = chatList.get(position).getSentAt();
        String message = chatList.get(position).getMessage();
        try{
            SimpleDateFormat formatter = new SimpleDateFormat("h:mm a");
            holder.setData(message, formatter.format(date), chatList.get(position).isMe);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return chatList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

       private TextView theirText;
       private TextView myText;
       private TextView theirSentAt;
       private TextView mySentAt;
       private CardView theirView;
       private CardView myView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            theirText = itemView.findViewById(R.id.their_msg);
            myText = itemView.findViewById(R.id.my_msg);
            theirSentAt = itemView.findViewById(R.id.timing);
            mySentAt = itemView.findViewById(R.id.timing1);

            theirView = itemView.findViewById(R.id.chat_box_their);
            myView = itemView.findViewById(R.id.chat_box_me);

        }
        public void setData(String message, String sentAt, boolean isMe) {
            theirText.setText(message);
            myText.setText(message);
            theirSentAt.setText(sentAt);
            mySentAt.setText(sentAt);
            theirView.setVisibility(isMe ? View.INVISIBLE : View.VISIBLE);
            myView.setVisibility(!isMe ? View.INVISIBLE : View.VISIBLE);
        }

    }
}
