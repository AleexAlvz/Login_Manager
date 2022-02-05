package com.aleexalvz.login_manager

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.aleexalvz.login_manager.data.user.UserDatabase

class CustomApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        appContext = this
    }

    companion object{
        lateinit var appContext: Context

        fun getUserDB(): UserDatabase = Room.databaseBuilder(appContext, UserDatabase::class.java, "user_db").build()
    }



}