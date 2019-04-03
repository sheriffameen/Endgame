package com.example.endgame;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements Callback<CharacterResponse>,CharacterNavigator {
    final List<Fragment> fragmentList = new ArrayList<>();


    private static final String TAG = "Main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getCharacters();

    }

    private void getCharacters() {
        Call<CharacterResponse> characterResponseCall = CharacterClient.getInstance().getCharacterResponse();
        characterResponseCall.enqueue(this);
    }

    @Override
    public void onResponse(Call<CharacterResponse> call, Response<CharacterResponse> response) {
        CharacterResponse characterResponse = response.body();
        List<Character> characters = characterResponse.getCharacters();
        Log.d(TAG, characters.toString());

        for (Character character : characters){
           EndgameFragment endgameFragment = EndgameFragment.newInstance(character);
           fragmentList.add(endgameFragment);


        }
        ViewPager viewPager = findViewById(R.id.mainActivity_viewPager);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(),fragmentList));


    }

    @Override
    public void onFailure(Call<CharacterResponse> call, Throwable t) {
        Log.d(TAG, t.toString());


    }

    @Override
    public void toCharacterFragment(Character character) {
        CharacterFragment characterFragment = CharacterFragment.newInstance(character);
        inflateFragment(characterFragment);

    }

    private void inflateFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_container,fragment).addToBackStack(null)
                .commit();
    }
}
