package com.example.whatsapp.fragements;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.whatsapp.adapters.usersadapter;
import com.example.whatsapp.databinding.FragmentChatsBinding;
import com.example.whatsapp.user;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class chatsFragment extends Fragment {


    public chatsFragment() {

    }

    FragmentChatsBinding binding;
    ArrayList<user> list = new ArrayList<>();

    FirebaseDatabase  database;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding=FragmentChatsBinding.inflate(inflater, container, false);
        database = FirebaseDatabase.getInstance();



        final usersadapter adapter = new usersadapter(list,getContext());
        binding.chatrecyclerview.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        binding.chatrecyclerview.setLayoutManager(linearLayoutManager);

        database.getReference().child("user").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                    user u = dataSnapshot.getValue(user.class);
                    u.setUserId(dataSnapshot.getKey());
                    list.add(u);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        return binding.getRoot();
    }
}