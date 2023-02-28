package com.example.chattingapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class profile_Adapter extends RecyclerView.Adapter<profile_Adapter.ViewHolder> {
//     private Context n_context;
   private List<Profile_Model> profileList;
   public profile_Adapter(List<Profile_Model>profileList){this.profileList= profileList;}
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_img, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

       
        
       int image = profileList.get(position).getImageView();
       String name = profileList.get(position).getTextView();
       holder.setData(image,name);

    }

    @Override
    public int getItemCount() {
        return profileList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{


       private ImageView imageView;
       private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

//            n_context = itemView.getContext();

            imageView = itemView.findViewById(R.id.image);
            textView = itemView.findViewById(R.id.users);


//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(n_context,profile_info.class);
//                    n_context.startActivity(intent);
//                }
//            });
        }

        public void setData(int image, String name) {

            imageView.setImageResource(image);
            textView.setText(name);
        }
    }
}
