package com.patikadev.mvvmsample.ui.filmlist.model.response

import com.google.gson.annotations.SerializedName

data class ForecastModelResponse(
    val current : Current,
    val location : Location,
    val forecast : Forecast,

)

data class Forecast (
    val forecastday: ArrayList<ForecastDay>
)

data class ForecastDay (
    @SerializedName("hour")
    val cityHours : List<CityHours>
)
data class CityHours(
    val time: String,
    val temp_c : Double,
    val temp_f : Double,
    val feelslike_c : Double,
    val feelslike_f : Double,
    val condition : CityCondition
)
