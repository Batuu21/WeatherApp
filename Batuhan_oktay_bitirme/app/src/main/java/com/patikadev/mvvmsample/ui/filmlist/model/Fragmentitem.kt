package com.patikadev.mvvmsample.ui.filmlist.model


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey



@Entity(tableName = "FRAGMENTS")
data class Fragmentitem(

    @PrimaryKey @ColumnInfo(name = "title") val title: String,
    @ColumnInfo  val temp_c : Double,
    @ColumnInfo val temp_f : Double,
    @ColumnInfo val feelslike_c : Double,
    @ColumnInfo val feelslike_f : Double,
    @ColumnInfo val text : String,
    @ColumnInfo val icon : String,

    )