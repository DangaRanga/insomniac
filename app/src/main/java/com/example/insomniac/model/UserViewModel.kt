package com.example.insomniac.model

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import com.example.insomniac.model.user.User
import com.example.insomniac.model.user.UserDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class UserViewModel(application: Application):AndroidViewModel(application) {
    private val repo:InsomniacRepo
    private val user: User

    init{
        val db = InsomniacDB.getDatabase(application, viewModelScope)
        val userDao = db.userDao()

        repo = InsomniacRepo(userDao)
        user = repo.getUser(0)

    }

    fun insert(user: User) = viewModelScope.launch(Dispatchers.IO){
        repo.insert(user)
    }

    fun getUser(uid: Int): User {
        return repo.getUser(uid)
    }

    fun getAllUsers(): LiveData<List<User>> {
        return repo.getAllUsers()
    }
}