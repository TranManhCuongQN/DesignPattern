package com.android.appmusic11.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.android.appmusic11.R;

public class MainActivity extends AppCompatActivity {
    View view , viewApp ,viewApp1;
    Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getIntent().getBooleanExtra("EXIT", false)){
            finish();
        }else {
            view = findViewById(R.id.logomain);
            viewApp = findViewById(R.id.txtApp);
            viewApp1 = findViewById(R.id.txtApp1);
            overridePendingTransition(R.anim.anim_intent_in, R.anim.anim_intent_out);
            animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_intent_in_main);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    view.setVisibility(View.VISIBLE);
                    view.startAnimation(animation);
                    viewApp.setVisibility(View.VISIBLE);
                    viewApp.startAnimation(animation);
                    viewApp1.setVisibility(View.VISIBLE);
                    viewApp1.startAnimation(animation);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(MainActivity.this,TrangChuActivity.class);
                            startActivity(intent);
                        }
                    },3500);
                }
            }, 2000);

        }
    }
}