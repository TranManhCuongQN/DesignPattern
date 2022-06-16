package com.android.appmusic11.Service_Local;

import android.media.MediaPlayer;

public class PlayState implements State{
    private Song song;
    public PlayState(Song song){
        this.song = song;
    }
    @Override
    public void play(MediaPlayer mediaPlayer) {
         mediaPlayer.start();
    }

    @Override
    public void resume(MediaPlayer mediaPlayer) {
    }

    @Override
    public void pause(MediaPlayer mediaPlayer) {
         this.song.setState(this.song.getPauseState());
    }
}
