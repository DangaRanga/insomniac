package com.example.insomniac.model.user

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.OnConflictStrategy

@Dao
interface UserDao {

    @Query("SELECT * FROM User WHERE id = :uid")
    fun getUser(uid:Int): User

    @Query("SELECT * FROM User")
    fun getAllUsers(): LiveData<List<User>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user:User)


    @Query("DELETE FROM user")
    suspend fun deleteUser()
}