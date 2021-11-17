package com.example.insomniac.ui.statistics

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.insomniac.model.InsomniacDB
import com.example.insomniac.model.InsomniacRepo
import com.example.insomniac.model.user.User

class StatisticsViewModel(application: Application): AndroidViewModel(application){
    // TODO: Implement the ViewModel
    private val repo:InsomniacRepo
    private val user: User

    init {
        val db = InsomniacDB.getDatabase(application, viewModelScope)
        val userDao = db.userDao()
        val statsAwakeDao=db.statsAwakeDao()
        val statsSleepDao=db.statsSleepDao()

        repo = InsomniacRepo(userDao,statsAwakeDao, statsSleepDao)
        user = repo.getUser(0)
    }


    fun getAwakeata(){
        return
    }
}