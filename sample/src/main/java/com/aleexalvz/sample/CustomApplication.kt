package com.aleexalvz.sample

import android.app.Application
import android.content.Intent
import com.aleexalvz.login_manager.builder.LoginManager

class CustomApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initLoginManager()
    }

    private fun initLoginManager() {
        LoginManager.Builder(this, MainActivity::class.java).init()
    }
}