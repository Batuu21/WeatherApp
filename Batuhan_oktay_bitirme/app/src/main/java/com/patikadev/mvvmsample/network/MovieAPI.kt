package com.patikadev.mvvmsample.network



import com.patikadev.mvvmsample.ui.filmlist.model.CityModel

import com.patikadev.mvvmsample.ui.filmlist.model.response.CityCurrentResponse
import com.patikadev.mvvmsample.ui.filmlist.model.response.ForecastModelResponse
import retrofit2.http.*

interface MovieAPI {


    @GET("search.json")
    suspend fun getCities(@Query("key") apikey : String, @Query("q") cityName : String) : List<CityModel>

    @GET("current.json")
    suspend fun getCUrrent(@Query("key") apikey : String, @Query("q") cityName : String) : CityCurrentResponse

    @GET("forecast.json")
    suspend fun getDetail(@Query("key") apikey : String, @Query("q") cityName : String) : ForecastModelResponse?

}