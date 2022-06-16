package com.android.appmusic11.Service_Local;

import android.content.Context;
import android.media.MediaPlayer;

interface  State {
  public void play(MediaPlayer mediaPlayer);
  public void resume(MediaPlayer mediaPlayer);
  public void pause(MediaPlayer mediaPlayer);
}
