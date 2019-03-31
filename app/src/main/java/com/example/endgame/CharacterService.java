package com.example.endgame;

import retrofit2.Call;
import retrofit2.http.GET;


/**
 * https://gist.githubusercontent.com/sheriffameen/e38aa33323cc689dcf08f7822f522742/raw/79c2e1bcbee420335c707353ffd54076af2ec502/MarvelCharacters
 * https://gist.githubusercontent.com/sheriffameen/e38aa33323cc689dcf08f7822f522742/raw/693d00f5506e2f979d9e8ef6e36e847df5855f9a/MarvelCharacters
 * https://gist.githubusercontent.com/sheriffameen/e38aa33323cc689dcf08f7822f522742/raw/170820427e0797f0b1baeb0e5f722184fe6ab65f/MarvelCharacters
 */
public interface CharacterService {

    @GET("sheriffameen/e38aa33323cc689dcf08f7822f522742/raw/170820427e0797f0b1baeb0e5f722184fe6ab65f/MarvelCharacters")
    Call<CharacterResponse>getCharacters();

}
