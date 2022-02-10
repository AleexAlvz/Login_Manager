package com.aleexalvz.login_manager.data.user

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.aleexalvz.login_manager.LoginApplication
import java.lang.Exception


@Database(entities = [User::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract val dao: UserDAO

    class Builder() {
        fun getDB(): UserDatabase? {
            return try {
                Room.databaseBuilder(
                    LoginApplication.appContext!!,
                    UserDatabase::class.java,
                    "user_db"
                ).fallbackToDestructiveMigration().build()
            }catch (error: Exception){
                null
            }
        }
    }
}