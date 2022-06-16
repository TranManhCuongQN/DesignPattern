package com.android.appmusic11.Service_Local;

import android.media.MediaPlayer;

public class PauseState implements State{
    private Song song;
    public PauseState(Song song){
        this.song = song;
    }
    @Override
    public void play(MediaPlayer mediaPlayer) {
    }

    @Override
    public void resume(MediaPlayer mediaPlayer) {
        this.song.setState(this.song.getResumeState());
    }

    @Override
    public void pause(MediaPlayer mediaPlayer) {
           mediaPlayer.pause();
    }
}
