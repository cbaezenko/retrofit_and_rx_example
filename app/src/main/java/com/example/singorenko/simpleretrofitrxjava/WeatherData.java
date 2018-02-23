package com.example.singorenko.simpleretrofitrxjava;

/**
 * Created by baeza on 23/2/18.
 */

public class WeatherData {

    String date, minTemp, maxTemp;

    public WeatherData(String date, String minTemp, String maxTemp){
        this.date = date;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }

    public String getDate() {return date;}
    public String getMinTemp() {return minTemp;}
    public String getMaxTemp() {return maxTemp;}
}
