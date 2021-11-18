package com.example.insomniac.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.insomniac.model.stats.StatsAwake
import com.example.insomniac.model.stats.StatsAwakeDao
import com.example.insomniac.model.stats.StatsSleep
import com.example.insomniac.model.stats.StatsSleepDao
import com.example.insomniac.model.user.User
import com.example.insomniac.model.tips.Tips
import com.example.insomniac.model.tips.TipsDao

import com.example.insomniac.model.user.UserDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [User::class,StatsAwake::class,StatsSleep::class, Tips::class], version = 2, exportSchema = false)
public abstract class InsomniacDB: RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun statsAwakeDao(): StatsAwakeDao
    abstract fun statsSleepDao(): StatsSleepDao

    abstract fun TipsDao(): TipsDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: InsomniacDB? = null

        fun getDatabase(context: Context, scope: CoroutineScope): InsomniacDB {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    InsomniacDB::class.java,
                    "Insomniac_DB"
                ).addCallback(InsomniacDBCallback(scope)).fallbackToDestructiveMigration().allowMainThreadQueries().build()
                INSTANCE = instance
                return instance
            }
        }
    }

//    .addCallback(InsomniacDBCallback(scope))
    private class InsomniacDBCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.userDao(),database.statsAwakeDao(),database.statsSleepDao(),database.TipsDao())
                }
            }
        }

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch { }
            }
        }
        suspend fun populateDatabase(
            userDao: UserDao,
            statsAwakeDao: StatsAwakeDao,
            statsSleep: StatsSleepDao,
            tipsDao: TipsDao
        ) {
//            userDao.deleteAll()
//
//            var user = User(0,"John Doe", "Male", 21, 5, 11, 160, "Active",true, false, false )
//            userDao.insertUser(user)
        }
    }
}



