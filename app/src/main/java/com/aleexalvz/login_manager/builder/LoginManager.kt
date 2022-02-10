package com.aleexalvz.login_manager.builder

import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import com.aleexalvz.login_manager.LoginApplication
import com.aleexalvz.login_manager.data.user.User
import com.aleexalvz.login_manager.ui.main.LoginManagerActivity

object LoginManager {

    var onLoginSuccessfull: (()->Unit)? = null

    private var LoggedUser: User? = null

    internal fun login(user: User) {
        saveLoggedUser(user)
        onLoginSuccessfull?.invoke()
    }

    internal fun saveLoggedUser(user: User) {
        LoggedUser = user
    }

    internal fun clearLoggedUser() {
        LoggedUser = null
    }

    fun getLoggedUser(): User? = LoggedUser

    fun logout(context: Context) {
        LoggedUser = null

        val intent = Intent(
            context,
            LoginManagerActivity::class.java
        ).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK and Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(context, intent, null)
    }

    class Builder(
        val context: Context,
        val onLoginSuccessful: (()->Unit)
    ) {
        fun init() {
            LoginApplication.appContext = context
            onLoginSuccessfull = this.onLoginSuccessful

            val intent = Intent(context, LoginManagerActivity::class.java)
            startActivity(context, intent, null)
        }
    }
}