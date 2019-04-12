package com.example.endgame.activities;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.VideoView;

import com.example.endgame.R;
import com.example.endgame.ThanosEndgameFragment;
import com.example.endgame.fragments.ThanosFragment;
import com.example.endgame.model.Thanos;
import com.example.endgame.model.ThanosResponse;
import com.example.endgame.services.MarvelClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePageActivity extends AppCompatActivity implements Callback<ThanosResponse> ,ThanosNavigator{
    private static final String TAG = "HomePageActivity";
    private VideoView videoView;
    private MediaPlayer mediaPlayer;
    int videoPosition;
    private Button heroesButton;
    private Button villainButton;
    private Thanos thanos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);


        videoView = findViewById(R.id.video_view);
        heroesButton = findViewById(R.id.heroes_button);
        villainButton = findViewById(R.id.villain_button);
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
        getThanos();


        heroesButton.setOnClickListener(v -> {
            Intent intent = new Intent(HomePageActivity.this, MainActivity.class);
            startActivity(intent);
        });

        villainButton.setOnClickListener(v -> {

            ThanosEndgameFragment thanosEndgameFragment = ThanosEndgameFragment.newInstance(thanos);
            inflateFragment(thanosEndgameFragment);

        });

    }

    public void getThanos(){
        Call<ThanosResponse> thanosResponseCall = MarvelClient.getInstance().getThanosResponse();
        thanosResponseCall.enqueue(this);
    }

    private void inflateFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_container,fragment)
                .addToBackStack(null)
                .commit();
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
        this.thanos = thanosResponse.getThanos().get(0);
        Log.d(TAG,thanos.toString());


    }

    @Override
    public void onFailure(Call<ThanosResponse> call, Throwable t) {
        Log.d(TAG,t.toString());


    }

    @Override
    public void toThanosFragment(Thanos thanos) {
        ThanosFragment thanosFragment = ThanosFragment.newInstance(thanos);
        inflateFragment(thanosFragment);


    }
}
