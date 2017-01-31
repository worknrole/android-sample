package com.worknrole.sample.externallibraries.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by worknrole on 24/01/17.
 *
 * A simple gyphy service
 * Note that the public key provides by Gyphy <a href="https://github.com/Giphy/GiphyAPI">here</a>
 */

public interface GyphyService {

    String API_URL = "http://api.giphy.com/v1/gifs/";
    String PUBLIC_API_KEY = "dc6zaTOxFJmzC";

    @GET("search?api_key=" + PUBLIC_API_KEY)
    Call<GyphyResponse> retrieveGyphyList(
            @Query(value="q", encoded = true) String term,
            @Query(value="limit", encoded = true) int limit,
            @Query(value="offset", encoded = true) int offset);
}
