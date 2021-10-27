package com.patikadev.mvvmsample.db

import androidx.room.*
import com.patikadev.mvvmsample.ui.filmlist.model.Fragmentitem


@Dao
interface CityDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insercity(fragmentitem: Fragmentitem )

    @Query("SELECT * FROM FRAGMENTS ")
    suspend fun  getCities() : List<Fragmentitem>

    @Update
    suspend fun update(fragmentitem: Fragmentitem)
}