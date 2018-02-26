package com.example.singorenko.simpleretrofitrxjava.data.remote;

import com.example.singorenko.simpleretrofitrxjava.data.model.WeatherData;

import rx.Observable;

import retrofit2.http.GET;

/**
 * Created by baeza on 24/2/18.
 */

public interface ApiService {

    @GET("staticweather")
    Observable<WeatherData> getExample();

}
