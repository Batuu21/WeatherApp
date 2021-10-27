package com.patikadev.mvvmsample.ui.filmlist

import androidx.lifecycle.*
import com.patikadev.mvvmsample.Result

import com.patikadev.mvvmsample.repository.FilmRepository
import com.patikadev.mvvmsample.ui.filmlist.model.*
import com.patikadev.mvvmsample.ui.filmlist.model.response.CityCurrentResponse
import com.patikadev.mvvmsample.ui.filmlist.model.response.ForecastModelResponse
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.launch

class SearchListViewModel(private val filmRepository: FilmRepository) : ViewModel() {




    var citiesflow = MutableLiveData<List<CityModel>>()
    var cityCurrent = MutableLiveData<CityCurrentResponse>()
    var CitiesFromDb = MutableLiveData<List<Fragmentitem>>()
    var cityDetail=MutableLiveData<ForecastModelResponse>()
    var currentlist : ArrayList<CityCurrentResponse> = arrayListOf()
    var updateList = MutableLiveData<List<CityCurrentResponse>>()


    fun prepareMovies(name:String) {

        viewModelScope.launch {


            citiesflow =
                filmRepository.flowcity(name).asLiveData() as MutableLiveData<List<CityModel>>


        }
    }
    fun getCities(){
        viewModelScope.launch {
            CitiesFromDb.value=  filmRepository.getAllcitiesFromdb()
        }

    }
    fun AddCity(fragmentitem: Fragmentitem){
        viewModelScope.launch {
          filmRepository.AddCitytoDb(fragmentitem)
        }

    }



    fun getCurrent(name: String) {
        viewModelScope.launch {
            cityCurrent= filmRepository.flowCurrent(name).asLiveData() as MutableLiveData<CityCurrentResponse>
            cityCurrent.value

        }
    }

    fun getCurrentForUpdate(name: String) {
        viewModelScope.launch {
          var x =  filmRepository.flowCurrent(name).asLiveData() as MutableLiveData<CityCurrentResponse>

                x.value?.let {
                    currentlist.add(it)
                }


            updateList.value= currentlist

            var res =  filmRepository.flowCurrent(name).first()

        }
    }

    fun getDetail(name: String) {
        viewModelScope.launch {
            cityDetail= filmRepository.flowDetail(name).asLiveData() as MutableLiveData<ForecastModelResponse>


        }
    }

}