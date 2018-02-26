package com.example.singorenko.simpleretrofitrxjava.data.remote;

import com.example.singorenko.simpleretrofitrxjava.data.model.WeatherData;

import retrofit2.http.Query;
import rx.Observable;

import retrofit2.http.GET;

/**
 * Created by baeza on 24/2/18.
 */

public interface ApiService {

    @GET("staticweather")
    Observable<WeatherData> getExample();

    //In case to need a key
    @GET("top_rated?api_key")
    Observable<WeatherData> getMovieListRated(@Query("api_key") String api_key);

}
