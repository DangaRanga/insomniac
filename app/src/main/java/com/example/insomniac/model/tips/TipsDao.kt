package com.example.insomniac.model.tips

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.OnConflictStrategy


@Dao
interface TipsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTip(tip : Tips)

    @Query("SELECT * FROM tips ORDER BY id ASC")
    fun readAllData(): List<Tips>

    @Query("DELETE FROM tips")
    suspend fun deleteAll()

    @Query("SELECT * FROM tips ORDER BY RANDOM() LIMIT 4")
    fun getRandomTips(): List<Tips>

}