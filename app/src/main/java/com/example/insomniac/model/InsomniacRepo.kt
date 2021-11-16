package com.example.insomniac.model

import androidx.lifecycle.LiveData
import com.example.insomniac.model.user.User
import com.example.insomniac.model.user.UserDao

class InsomniacRepo (private val userDao: UserDao){

//    val users: LiveData<List<User>> = UserDao.getAllUsers()

    suspend fun insert(user: User){
        userDao.insertUser(user)
    }

    fun getUser(uid:Int): User {
        return userDao.getUser(uid)
    }

}