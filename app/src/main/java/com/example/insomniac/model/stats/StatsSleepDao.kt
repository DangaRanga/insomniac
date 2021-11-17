package com.example.insomniac.model.stats

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.OnConflictStrategy
import com.example.insomniac.model.stats.StatsAwake
@Dao
interface StatsSleepDao {

    //Rmbr to select last record
    @Query("SELECT * FROM sleep ")
    fun getLastSleep(): List<StatsSleep>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertSleep(statsSleep: StatsSleep)

    @Query("DELETE FROM sleep")
    suspend fun deleteAll()
}