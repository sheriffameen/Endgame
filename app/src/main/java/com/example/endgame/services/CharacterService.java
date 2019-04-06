package com.example.endgame.services;

import com.example.endgame.model.CharacterResponse;

import retrofit2.Call;
import retrofit2.http.GET;


/**
 * https://gist.githubusercontent.com/sheriffameen/e38aa33323cc689dcf08f7822f522742/raw/d5142212a77edf74feeab3d211ee01a3b12475e9/MarvelCharacters
 * https://gist.githubusercontent.com/sheriffameen/e38aa33323cc689dcf08f7822f522742/raw/f3b8a016587f941f74c558a4c8b73690b538e9d5/MarvelCharacters
 */
public interface CharacterService {

    @GET("sheriffameen/e38aa33323cc689dcf08f7822f522742/raw/f3b8a016587f941f74c558a4c8b73690b538e9d5/MarvelCharacters")
    Call<CharacterResponse>getCharacters();

}
