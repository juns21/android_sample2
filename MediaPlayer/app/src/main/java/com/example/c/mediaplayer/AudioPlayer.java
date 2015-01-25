package com.example.c.mediaplayer;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by c on 2015-01-25.
 */
public class AudioPlayer {
    private MediaPlayer mPlayer = null;

    public void play(Context c) {
        stop();

        mPlayer = MediaPlayer.create(c, R.raw.one_small_step);
        mPlayer.start();

        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stop();
            }
        });
    }

    public void stop() {
        if (mPlayer != null) {
            mPlayer.stop();
            mPlayer.release();
            mPlayer = null;
        }
    }
}
