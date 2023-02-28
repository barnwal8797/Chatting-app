package com.example.chattingapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private Context mcontext;
    private List<Model> userList;
    public Adapter(List<Model>userList){this.userList = userList;}
    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.customview,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {

        int image = userList.get(position).getImageview();
        String name = userList.get(position).getTextview();
        String message = userList.get(position).getTextview2();
        String time = userList.get(position).getTextview3();
//        itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(context,user1.class);
//                intent.putExtra("image","imageview");
//                intent.putExtra("name","username");
//
//                context.startActivity(intent);
//
//                Toast.makeText(itemView.getContext(), textView.getText(), Toast.LENGTH_SHORT).show();
//            }
//        });

        holder.setData(image,name,message,time);

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView textView;
        private TextView textView2;
        private TextView textView3;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mcontext = itemView.getContext();

            imageView = itemView.findViewById(R.id.image);
            textView = itemView.findViewById(R.id.users);
            textView2 = itemView.findViewById(R.id.message);
            textView3 = itemView.findViewById(R.id.time);

        }

        public void setData(int image, String name, String message, String time) {

            imageView.setImageResource(image);
            textView.setText(name);
            textView2.setText(message);
            textView3.setText(time);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(mcontext,user1.class);
                    intent.putExtra("name",textView.getText());
                    intent.putExtra("image", image);
                    mcontext.startActivity(intent);
                    Toast.makeText(itemView.getContext(), textView.getText(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
