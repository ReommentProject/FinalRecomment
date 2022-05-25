package com.example.recomment;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {
    String BASE_URL = "http://113.198.137.183:7999/";
    @GET("users")
    Call<List<Content>> getMainContent();

    /*
    @POST("users/cUser")
    Call<Content> createUser(@Body Content content);
     */
}
