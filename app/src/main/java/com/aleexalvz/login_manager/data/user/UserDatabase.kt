package com.aleexalvz.login_manager.data.user

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [User::class], version = 2)
abstract class UserDatabase : RoomDatabase() {
    abstract val dao: UserDAO

    companion object {

        private var INSTANCE: UserDatabase? = null

        fun getInstance(context: Context): UserDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        UserDatabase::class.java,
                        "user_db"
                    ).fallbackToDestructiveMigration().build()


                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}