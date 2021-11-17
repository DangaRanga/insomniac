package com.example.insomniac.model

import androidx.lifecycle.LiveData
import com.example.insomniac.model.user.User
import com.example.insomniac.model.user.UserDao
import com.example.insomniac.model.stats.StatsAwakeDao
import com.example.insomniac.model.stats.StatsAwake
import com.example.insomniac.model.stats.StatsSleep
import com.example.insomniac.model.stats.StatsSleepDao

class InsomniacRepo (private val userDao: UserDao,private val  statsAwakeDao: StatsAwakeDao,private val statsSleepDao: StatsSleepDao){

//    val users: LiveData<List<User>> = UserDao.getAllUsers()

    suspend fun insert(user: User){
        userDao.insertUser(user)
    }

    suspend fun insertStatsSleep(statsSleep: StatsSleep){
        statsSleepDao.insertSleep(statsSleep)
    }

    suspend fun insertStatsAwake(statsAwake: StatsAwake){
        statsAwakeDao.insertAwake(statsAwake)
    }

    fun getLastStatsSleep():LiveData<List<StatsSleep>>{
        return statsSleepDao.getLastSleep()
    }

    fun getUser(uid:Int): User {
        return userDao.getUser(uid)
    }
    
     fun getAllUsers(): LiveData<List<User>> {
        return userDao.getAllUsers()
      
     fun getLastStatsAwake():LiveData<List<StatsAwake>>{
        return statsAwakeDao.getLastStats()

    }

}