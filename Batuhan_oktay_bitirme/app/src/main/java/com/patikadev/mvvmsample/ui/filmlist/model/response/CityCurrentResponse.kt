package com.patikadev.mvvmsample.ui.filmlist.model.response

data class CityCurrentResponse(
   val current : Current,
   val location : Location
)


data class Current(
    val temp_c : Double,
    val temp_f : Double,
    val feelslike_c : Double,
    val feelslike_f : Double,
    val condition: CityCondition
)

data class CityCondition (
    val text : String,
    val icon : String,
)
data class Location(
    val name : String
)