package com.aleexalvz.sample

import android.app.Application
import com.aleexalvz.login_manager.builder.LoginManager

class CustomApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        LoginManager.Builder(this, MainActivity::class.java)
    }
}