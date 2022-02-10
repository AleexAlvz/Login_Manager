package com.aleexalvz.sample

import android.app.Application
import android.content.Intent
import com.aleexalvz.login_manager.builder.LoginManager

class CustomApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        LoginManager.Builder(this){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}