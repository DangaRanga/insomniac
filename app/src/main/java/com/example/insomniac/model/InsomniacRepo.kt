package com.example.insomniac.model

import androidx.lifecycle.LiveData
import com.example.insomniac.model.user.User
import com.example.insomniac.model.user.UserDao
import com.example.insomniac.model.stats.StatsAwakeDao
import com.example.insomniac.model.stats.StatsAwake
import com.example.insomniac.model.stats.StatsSleep
import com.example.insomniac.model.stats.StatsSleepDao
import com.example.insomniac.model.tips.Tips
import com.example.insomniac.model.tips.TipsDao

class InsomniacRepo (private val userDao: UserDao,private val  statsAwakeDao: StatsAwakeDao,private val statsSleepDao: StatsSleepDao,private val tipsDao: TipsDao){

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

    fun getLastStatsSleep():List<StatsSleep>{
        return statsSleepDao.getLastSleep()
    }

    fun getUser(uid:Int): User {
        return userDao.getUser(uid)
    }

    fun getAllUsers(): List<User> {
        return userDao.getAllUsers()
    }
    fun getLastStatsAwake():List<StatsAwake>{
        return statsAwakeDao.getLastStats()
    }

    suspend fun insert(tip: Tips){
        tipsDao.addTip(tip)
    }
    fun getRandomTips():List<Tips>{
        return tipsDao.getRandomTips()
    }

}