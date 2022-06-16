package com.android.appmusic11.Service_Local;

import android.media.MediaPlayer;

public class ResumeState implements State{
    private Song song;
    public ResumeState(Song song){
        this.song = song;
    }
    @Override
    public void play(MediaPlayer mediaPlayer) {
    }

    @Override
    public void resume(MediaPlayer mediaPlayer) {
        mediaPlayer.start();

    }

    @Override
    public void pause(MediaPlayer mediaPlayer) {
        this.song.setState(this.song.getPauseState());
    }
}
