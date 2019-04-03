package com.example.endgame;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class SplashActivity extends AppCompatActivity {
    private ImageView splashImage;
    private static int SPLASH_SCREEN_TIMER = 6000;
    private Intent toLoginScreenIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        splashImage = findViewById(R.id.splash_screen_image);

        Glide.with(SplashActivity.this)
                .load(R.drawable.marvelsplash)
                .into(splashImage);


        new Handler().postDelayed(() -> {

            toLoginScreenIntent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(toLoginScreenIntent);
            finish();
        }, SPLASH_SCREEN_TIMER);
    }
}

