package com.android.appmusic11.Service_Local;

import android.media.MediaPlayer;

public class Song {
    private State state;
    private final State resumeState = new ResumeState(this);
    private final State playState = new PlayState(this);
    private final State pauseState = new PauseState(this);

    public Song(){
        this.state = getPlayState();
    }
    public void setState(State state) {
        this.state = state;
    }

    public State getPlayState() {
        return playState;
    }
    public State getPauseState() {
        return pauseState;
    }
    public State getResumeState() {
        return resumeState;
    }
    public void Play(MediaPlayer mediaPlayer){
      this.state.play(mediaPlayer);
      if(state != getPauseState()) {
          this.state.pause(mediaPlayer);
      }
    }
    public void Pause(MediaPlayer mediaPlayer){
     this.state.pause(mediaPlayer);
     this.state.resume(mediaPlayer);

    }
    public void Resume(MediaPlayer mediaPlayer){
        this.state.resume(mediaPlayer);
        this.state.pause(mediaPlayer);

    }
}
