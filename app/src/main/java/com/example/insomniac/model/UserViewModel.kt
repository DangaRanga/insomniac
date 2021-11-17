package com.example.insomniac.model

import android.app.Application
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.insomniac.model.stats.StatsAwake
import com.example.insomniac.model.stats.StatsSleep
import com.example.insomniac.model.user.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application):AndroidViewModel(application) {
    private val repo:InsomniacRepo
    private val user: User

    init{

        val db = InsomniacDB.getDatabase(application, viewModelScope)
        val userDao = db.userDao()
        val statsAwakeDao=db.statsAwakeDao()
        val statsSleepDao=db.statsSleepDao()


        repo = InsomniacRepo(userDao,statsAwakeDao, statsSleepDao)
        user = repo.getUser(0)

    }

    fun insert(user: User) = viewModelScope.launch(Dispatchers.IO){
        repo.insert(user)
    }

    fun getUser(uid: Int): User {
        return repo.getUser(uid)
    }
    fun getAllUsers(): List<User> {
        return repo.getAllUsers()
    }
    
    fun insertAwake(statsAwake: StatsAwake) = viewModelScope.launch(Dispatchers.IO){
        repo.insertStatsAwake(statsAwake)
    }

    fun getLastStatsAwake():List<StatsAwake> {
        return repo.getLastStatsAwake()
    }

    fun insertStatsSleep(statsSleep: StatsSleep) = viewModelScope.launch(Dispatchers.IO){
        repo.insertStatsSleep(statsSleep)
    }

    fun getLastStatsSleep():List<StatsSleep> {
        return repo.getLastStatsSleep()

    }
}