package com.example.singorenko.simpleretrofitrxjava.data.utilties;

import com.example.singorenko.simpleretrofitrxjava.data.remote.RetrofitClient;
import com.example.singorenko.simpleretrofitrxjava.data.remote.ApiService;

/**
 * Created by baeza on 23/2/18.
 */

public class ApiUtils {

    private ApiUtils(){}

    public static final String BASE_URL = "https://andfun-weather.udacity.com/";

    public static ApiService getApiService(){
        return  RetrofitClient.getClient(BASE_URL).create(ApiService.class);
    }
}
