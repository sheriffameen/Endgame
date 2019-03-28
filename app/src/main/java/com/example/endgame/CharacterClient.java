package com.example.endgame;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * https://gist.githubusercontent.com/sheriffameen/e38aa33323cc689dcf08f7822f522742/raw/693d00f5506e2f979d9e8ef6e36e847df5855f9a/MarvelCharacters
 */
public class CharacterClient {
    private static final String BASE_URL = "https://gist.githubusercontent.com/";
    private static CharacterClient instance;
    private Retrofit retrofit;


    public static CharacterClient getInstance(){
        if (instance == null){
            instance = new CharacterClient();

        }
        return instance;
    }

    private CharacterClient(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
    }

    private CharacterService getCharacterService(){
        return retrofit.create(CharacterService.class);
    }

    public Call<CharacterResponse> getCharacterResponse(){
        return getCharacterService().getCharacters();
    }
}
