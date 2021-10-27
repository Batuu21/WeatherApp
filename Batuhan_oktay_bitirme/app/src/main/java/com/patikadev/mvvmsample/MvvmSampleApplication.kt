package com.patikadev.mvvmsample

import android.app.Application
import com.patikadev.mvvmsample.di.dbModule
import com.patikadev.mvvmsample.di.networkModule
import com.patikadev.mvvmsample.di.repositoryModule
import com.patikadev.mvvmsample.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MvvmSampleApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MvvmSampleApplication)
            modules(networkModule, repositoryModule, viewModelModule, dbModule)
        }

    }
}