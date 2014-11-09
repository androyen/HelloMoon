package com.androyen.hellomoon;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by rnguyen on 11/6/14.
 */
public class HelloMoonFragment extends Fragment {

    //Play and Stop buttons
    private Button mPlayButton;
    private Button mStopButton;

    private AudioPlayer mPlayer = new AudioPlayer();

    //Override onCreate to Retain the whole Fragment instance
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_hello_moon, parent, false);

        //reference Play and Stop buttons
        mPlayButton = (Button)v.findViewById(R.id.hellomoon_playButton);
        mStopButton = (Button)v.findViewById(R.id.hellomoon_stopButton);

        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlayer.play(getActivity());
            }
        });

        mStopButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mPlayer.stop();
            }
        });

        return v;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPlayer.stop();
    }
}
