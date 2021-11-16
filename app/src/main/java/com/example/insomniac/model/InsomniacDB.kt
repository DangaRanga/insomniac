package com.example.insomniac.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.insomniac.R
import com.example.insomniac.model.user.User
import com.example.insomniac.model.user.UserDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [User::class], version = 2, exportSchema = false)
public abstract class InsomniacDB: RoomDatabase() {
    abstract fun userDao(): UserDao

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
                    "student_database"
                ).addCallback(InsomniacDBCallback(scope)).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                return instance
            }
        }
    }

    private class InsomniacDBCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.userDao())
                }
            }
        }
        suspend fun populateDatabase(userDao: UserDao) {
            userDao.deleteUser()

            val users = arrayListOf<User>()
            users.add(User(0,"John Doe", "Male", 21, 5, 11,
                160, true, false, false ))

            for(user in users) {
                userDao.insertUser(user)
            }
        }
    }
}



