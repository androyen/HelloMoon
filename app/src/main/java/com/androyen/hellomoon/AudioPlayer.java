package com.androyen.hellomoon;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by rnguyen on 11/6/14.
 */
public class AudioPlayer {

    private MediaPlayer mPlayer;

    //Stop and play methods
    public void stop() {
        if (mPlayer != null) {
            mPlayer.release();
            mPlayer = null;
        }
    }

    public void play(Context context) {
        //Stop MediaPlayer resource beforehand. Prevents multiple MediaPlayer objects created
        stop();
        mPlayer = MediaPlayer.create(context, R.raw.one_small_step);

        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                //Once the media file has completed playing, stop the resource
                stop();
            }
        });

        mPlayer.start();
    }
}
