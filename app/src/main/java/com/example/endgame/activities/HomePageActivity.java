package com.example.endgame.activities;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.VideoView;

import com.example.endgame.R;
import com.example.endgame.model.Thanos;
import com.example.endgame.model.ThanosResponse;
import com.example.endgame.services.MarvelClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePageActivity extends AppCompatActivity implements Callback<ThanosResponse> {
    private static final String TAG = "HomePageActivity";
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

        getThanos();
    }

    public void getThanos(){
        Call<ThanosResponse> thanosResponseCall = MarvelClient.getInstance().getThanosResponse();
        thanosResponseCall.enqueue(this);
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

    @Override
    public void onResponse(Call<ThanosResponse> call, Response<ThanosResponse> response) {
        ThanosResponse thanosResponse = response.body();
        Thanos thanos = thanosResponse.getThanos().get(0);
        Log.d(TAG,thanos.toString());

    }

    @Override
    public void onFailure(Call<ThanosResponse> call, Throwable t) {
        Log.d(TAG,t.toString());


    }
}
