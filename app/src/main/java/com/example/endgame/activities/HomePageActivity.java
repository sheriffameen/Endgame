package com.example.endgame.activities;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import com.example.endgame.R;

public class HomePageActivity extends AppCompatActivity {
    private VideoView videoView;
    private MediaPlayer mediaPlayer;
    int videoPosition;
    private Button heroesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        videoView = findViewById(R.id.video_view);
        heroesButton = findViewById(R.id.heroes_button);
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.marvel_trailer);

        videoView.setVideoURI(uri);
        videoView.start();

        videoView.setOnPreparedListener(mp -> {
            mediaPlayer = mp;
            mediaPlayer.setLooping(true);

            if (videoPosition != 0) {
                mediaPlayer.seekTo(videoPosition);
                mediaPlayer.start();
            }

        });

        heroesButton.setOnClickListener(v -> {
            Intent intent = new Intent(HomePageActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public void onPause() {
        super.onPause();

        videoPosition = mediaPlayer.getCurrentPosition();
        videoView.pause();
    }

    @Override
    public void onResume() {
        super.onResume();
        videoView.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
        mediaPlayer = null;
    }
}
