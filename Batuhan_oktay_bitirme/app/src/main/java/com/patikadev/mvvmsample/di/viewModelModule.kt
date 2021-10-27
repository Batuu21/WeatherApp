package com.patikadev.mvvmsample.di

import com.patikadev.mvvmsample.ui.filmlist.SearchListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SearchListViewModel(get())}
}