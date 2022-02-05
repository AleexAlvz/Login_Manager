package com.aleexalvz.login_manager.builder

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.core.view.ContentInfoCompat
import com.aleexalvz.login_manager.CustomApplication
import com.aleexalvz.login_manager.data.user.User
import com.aleexalvz.login_manager.ui.main.LoginManagerActivity

object LoginManager {
    private lateinit var startDestination: Class<Any>
    private var LoggedUser: User? = null

    internal fun onLoginSuccessful(user: User) {
        saveLoggedUser(user)

        val context = CustomApplication.appContext
        val intent = Intent(context, startDestination)
        startActivity(context, intent, null)
    }

    internal fun saveLoggedUser(user: User) {
        this.LoggedUser = user
    }

    internal fun clearLoggedUser(){
        this.LoggedUser = null
    }

    fun logout(){
        this.LoggedUser = null
        val context = CustomApplication.appContext

        val intent = Intent(context, LoginManagerActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK and Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(context, intent, null)
    }

    class Builder(
        val context: Context,
         val startDestination: Class<Any>
    ) {
        fun init() {
            LoginManager.startDestination = this.startDestination

            val intent = Intent(context, LoginManagerActivity::class.java)
            startActivity(context, intent, null)
        }
    }
}