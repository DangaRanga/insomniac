package com.example.insomniac.model.stats

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.OnConflictStrategy
import com.example.insomniac.model.stats.StatsAwake
@Dao
interface StatsAwakeDao {

    //Rmbr to select last record
    @Query("SELECT * FROM awake ")
    fun getLastStats(): List<StatsAwake>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAwake(statsAwake: StatsAwake)

    @Query("DELETE FROM awake")
    suspend fun deleteAll()
}