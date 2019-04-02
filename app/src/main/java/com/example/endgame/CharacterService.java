package com.example.endgame;

import retrofit2.Call;
import retrofit2.http.GET;


/**
 * https://gist.githubusercontent.com/sheriffameen/e38aa33323cc689dcf08f7822f522742/raw/79c2e1bcbee420335c707353ffd54076af2ec502/MarvelCharacters
 * https://gist.githubusercontent.com/sheriffameen/e38aa33323cc689dcf08f7822f522742/raw/693d00f5506e2f979d9e8ef6e36e847df5855f9a/MarvelCharacters
 * https://gist.githubusercontent.com/sheriffameen/e38aa33323cc689dcf08f7822f522742/raw/170820427e0797f0b1baeb0e5f722184fe6ab65f/MarvelCharacters
 * https://gist.githubusercontent.com/sheriffameen/e38aa33323cc689dcf08f7822f522742/raw/29613f2ae90cf1fbb2a6302a6da5ea04f628e028/MarvelCharacters
 * https://gist.githubusercontent.com/sheriffameen/e38aa33323cc689dcf08f7822f522742/raw/95fdce79ebeba54e7f8e5f5149eb32df6570c83c/MarvelCharacters
 * https://gist.githubusercontent.com/sheriffameen/e38aa33323cc689dcf08f7822f522742/raw/551b68397d1633f41043f6b75f5256fda707dded/MarvelCharacters
 * https://gist.githubusercontent.com/sheriffameen/e38aa33323cc689dcf08f7822f522742/raw/2b6461bf02984e739891ca0b886426bd1e2c588b/MarvelCharacters
 * https://gist.githubusercontent.com/sheriffameen/e38aa33323cc689dcf08f7822f522742/raw/ae42282f3c55dccf7d86cb9d26ca3e994a5f34ea/MarvelCharacters
 * https://gist.githubusercontent.com/sheriffameen/e38aa33323cc689dcf08f7822f522742/raw/d5142212a77edf74feeab3d211ee01a3b12475e9/MarvelCharacters
 */
public interface CharacterService {

    @GET("sheriffameen/e38aa33323cc689dcf08f7822f522742/raw/d5142212a77edf74feeab3d211ee01a3b12475e9/MarvelCharacters")
    Call<CharacterResponse>getCharacters();

}
