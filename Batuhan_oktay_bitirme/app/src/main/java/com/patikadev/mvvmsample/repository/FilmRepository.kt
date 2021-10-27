package com.patikadev.mvvmsample.repository


import com.patikadev.mvvmsample.db.CityDao
import com.patikadev.mvvmsample.network.MovieAPI
import com.patikadev.mvvmsample.ui.filmlist.model.Fragmentitem
import com.patikadev.mvvmsample.util.API_KEY2
import kotlinx.coroutines.flow.flow

class FilmRepository(private val api: MovieAPI, private val citydao: CityDao) {


    suspend fun getAllcitiesFromdb(): List<Fragmentitem> {
           return citydao.getCities()
    }
    suspend fun AddCitytoDb(fragmentitem: Fragmentitem){
        citydao.insercity(fragmentitem)
    }

    suspend fun flowcity(city : String)= flow {
        val response = api.getCities(API_KEY2,city)
        emit(response)
    }
    suspend fun flowCurrent(city : String)= flow {
        val response = api.getCUrrent(API_KEY2,city)
        emit(response)
    }
    suspend fun flowDetail(city : String)= flow {
        val response = api.getDetail(API_KEY2,city)
        emit(response)
    }
}