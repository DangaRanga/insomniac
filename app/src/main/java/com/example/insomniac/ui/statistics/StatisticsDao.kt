package com.example.insomniac.ui.statistics

import androidx.room.Dao
import androidx.room.Query

@Dao
interface StatisticsDao {

    // Overall Statistics will be  generated from all sleep data present for MVP
    @Query("SELECT * FROM timerdata")
    fun getAllData()

}