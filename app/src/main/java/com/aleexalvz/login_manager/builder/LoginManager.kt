package com.aleexalvz.login_manager.builder

import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import com.aleexalvz.login_manager.data.user.User
import com.aleexalvz.login_manager.ui.main.MainActivity
import java.lang.RuntimeException

object LoginManager {

    internal var postLoginDestination: Class<*>? = null

    private var LoggedUser: User? = null

    internal fun login(context: Context, user: User) {
        try {
            saveLoggedUser(user)
            startActivity(context, postLoginDestination!!)
        }catch (error: Exception){
            throw RuntimeException("Post login destination not defined")
        }
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
        startActivity(context, MainActivity::class.java)
    }

    class Builder(
        val context: Context,
        var postLoginDestination: Class<*>
    ) {
        fun init() {
            LoginManager.postLoginDestination = postLoginDestination
            startActivity(context, MainActivity::class.java)
        }
    }

    private fun startActivity(context: Context, destination: Class<*>){
        val intent = Intent(context, destination)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)

        startActivity(context, intent, null)
    }
}