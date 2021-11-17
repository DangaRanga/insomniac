package com.example.insomniac.model.user

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.OnConflictStrategy

@Dao
interface UserDao {

//    @Query("SELECT * FROM user ORDER BY id LIMIT 1")
//    fun  checkTable()

    @Query("SELECT * FROM user WHERE id = :uid")
    fun getUser(uid:Int): User

    @Query("SELECT * FROM user")
    fun getAllUsers(): List<User>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUser(user: User)

    @Query("DELETE FROM user")
    suspend fun deleteAll()
}