package com.example.mymusicapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class PlayerFragment extends Fragment {

    ImageView play;
    MediaPlayer mediaPlayer=null;

    public PlayerFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.fragment_player, container, false);
        mediaPlayer=MediaPlayer.create(getActivity().getApplicationContext(),R.raw.faded);

        play = view.findViewById(R.id.btn_play);
        play.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    play.setImageResource(R.drawable.icon_play);
                } else {
                    mediaPlayer.start();
                    play.setImageResource(R.drawable.icon_pause);
                }
            }
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        getView().setFocusableInTouchMode(true);
        getView().requestFocus();
        getView().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK) {
                    getFragmentManager().popBackStack();
                    mediaPlayer.release();
                    return true;
                }
                return false;
            }
        });
    }
}
