package com.example.daggersample.data.remote.api;

import com.example.daggersample.model.Hero;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    //String BASE_URL = "https://simplifiedcoding.net/demos/";

    /**
     * The return type is important here
     * The class structure that you've defined in Call<T>
     * should exactly match with your json response
     * If you are not using another api, and using the same as mine
     * then no need to worry, but if you have your own API, make sure
     * you change the return type appropriately
     **/
    @GET("marvel")
    Call<List<Hero>> getHeroes();

}