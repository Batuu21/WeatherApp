package com.patikadev.mvvmsample.di

import com.patikadev.mvvmsample.network.MovieAPI
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    factory { provideHttpClient() }
    single { provideMovieApi(get()) }
    single { provideRetrofit(get()) }
}



fun provideHttpClient() : OkHttpClient{
    //logging interceptor
    val logging = HttpLoggingInterceptor().apply {
        setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    //adding logging interceptor to okhttp
    val httpClient: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()

    return httpClient
}
fun provideRetrofit(httpClient: OkHttpClient) : Retrofit {

    val BASE_URL = "http://api.weatherapi.com/v1/"

    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient)
        .build()
}


fun provideMovieApi(retrofit: Retrofit) : MovieAPI{
    return  retrofit.create(MovieAPI::class.java)
}


