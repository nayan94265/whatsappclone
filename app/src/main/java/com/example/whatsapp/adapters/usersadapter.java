package com.example.whatsapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.whatsapp.R;
import com.example.whatsapp.user;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class usersadapter extends RecyclerView.Adapter<usersadapter.ViewHolder>{


    ArrayList<user> list;

    Context context;

    public usersadapter(ArrayList<user> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.show_user, parent , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        user u = list.get(position);
        Picasso.get().load(u.getProfilepic()).placeholder(R.drawable.man).into(holder.image);
        holder.showusername.setText(u.getUsername());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView showusername,lastmsg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.profile_image);
            showusername = itemView.findViewById(R.id.showusername);
            lastmsg = itemView.findViewById(R.id.lastmsg);
        }
    }
}
