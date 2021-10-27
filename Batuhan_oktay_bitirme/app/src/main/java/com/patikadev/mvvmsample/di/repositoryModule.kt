package com.patikadev.mvvmsample.di

import com.patikadev.mvvmsample.repository.FilmRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory { FilmRepository(get(), get()) }
}