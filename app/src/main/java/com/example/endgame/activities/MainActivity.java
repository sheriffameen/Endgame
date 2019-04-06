package com.example.endgame.activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.endgame.adapter.ViewPagerAdapter;
import com.example.endgame.fragments.EndgameFragment;
import com.example.endgame.model.CharacterResponse;
import com.example.endgame.navigator.CharacterNavigator;
import com.example.endgame.R;
import com.example.endgame.fragments.CharacterFragment;
import com.example.endgame.model.Character;
import com.example.endgame.services.CharacterClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements Callback<CharacterResponse>, CharacterNavigator {
    final List<Fragment> fragmentList = new ArrayList<>();
    private static final String TAG = "Main Fragment";





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getCharacters();



    }

    public void getCharacters(){
        Call<CharacterResponse> characterResponseCall = CharacterClient.getInstance().getCharacterResponse();
        characterResponseCall.enqueue(this);
    }







    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.contact_menu, menu);
        return true;

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
        Log.d(TAG,t.toString());

    }

    @Override
    public void toCharacterFragment(Character character) {
        CharacterFragment characterFragment = CharacterFragment.newInstance(character);
        inflateFragment(characterFragment);

    }

    private void inflateFragment(Fragment fragment){
       getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_container,fragment)
               .addToBackStack(null)
                .commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.GithubLink:
                linkIntent(getString(R.string.gitHubLink));
                return true;
            case R.id.linkedInLink:
                linkIntent(getString(R.string.linkedInLink));
                return true;
            default:
                return false;

        }
    }

    public void linkIntent(String link){

        Intent openLink = new Intent(Intent.ACTION_VIEW);
        openLink.setData(Uri.parse(link));

        if (openLink.resolveActivity(getPackageManager()) != null) {
            startActivity(openLink);
        }
    }

}
