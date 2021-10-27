package com.patikadev.mvvmsample.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.patikadev.mvvmsample.ui.filmlist.model.Fragmentitem


@Database(entities = [Fragmentitem::class], version = 1)
abstract class CityDB : RoomDatabase() {

    abstract fun citydao() : CityDao

}