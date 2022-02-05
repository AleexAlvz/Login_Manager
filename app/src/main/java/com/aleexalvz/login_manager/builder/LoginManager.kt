package com.aleexalvz.login_manager.builder

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import com.aleexalvz.login_manager.CustomApplication
import com.aleexalvz.login_manager.ui.main.LoginManagerActivity

object LoginManager {
    private lateinit var startDestination: Class<Activity>

    internal fun onLoginSuccessful() {
        val context = CustomApplication.appContext
        val intent = Intent(context, startDestination)
        startActivity(context, intent, null)
    }

    class Builder(
        val context: Context,
        val startDestination: Class<Activity>
    ) {
        fun init() {
            LoginManager.startDestination = this.startDestination

            val intent = Intent(context, LoginManagerActivity::class.java)
            startActivity(context, intent, null)
        }
    }
}