package lmd.pet.weathernew.data.api

import lmd.pet.weathernew.data.entity.weather.DailyWeather
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("/data/2.5/onecall")
    suspend fun getWeatherDaily(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("exclude") exclude: String,
        @Query("units") units: String,
        @Query("appid") appid: String
    ): Response<DailyWeather>

}