package com.example.mymusicapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static com.example.mymusicapp.MainActivity.fragmentManager;

public class MainFragment extends Fragment {

    public MainFragment() {
        // Required empty public constructor
    }

    TextView ImageChanger;
    TextView MusicPlayer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        view = inflater.inflate(R.layout.fragment_main, container, false);
        ImageChanger = view.findViewById(R.id.imagechanger);
        MusicPlayer = view.findViewById(R.id.musicplayer);

        MusicPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                PlayerFragment playerFragment = new PlayerFragment();
                fragmentTransaction.add(R.id.fragment_container,playerFragment,null);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        ImageChanger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                ImageChangerFragment imageChangerFragment = new ImageChangerFragment();
                fragmentTransaction.add(R.id.fragment_container,imageChangerFragment,null);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        return view;
    }

}
