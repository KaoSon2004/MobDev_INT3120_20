package com.example.week14

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {
    @GET("weather")
    fun getWeatherData(@Query("city") city: String): Call<WeatherData>
}