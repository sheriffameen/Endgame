package com.example.endgame.services;

import com.example.endgame.model.ThanosResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * https://gist.githubusercontent.com/sheriffameen/17c96bd4decbb40ce911c5af9b550aaa/raw/a55aded1178b6af82725a63f31e30ff79f89e3f0/ThanosGist
 * https://gist.githubusercontent.com/sheriffameen/17c96bd4decbb40ce911c5af9b550aaa/raw/aaf6fa5fb0877be783d88c718fc3e9c2053514c7/ThanosGist
 */

public interface ThanosService {

    @GET("sheriffameen/17c96bd4decbb40ce911c5af9b550aaa/raw/aaf6fa5fb0877be783d88c718fc3e9c2053514c7/ThanosGist")
    Call<ThanosResponse>getThanos();
}
