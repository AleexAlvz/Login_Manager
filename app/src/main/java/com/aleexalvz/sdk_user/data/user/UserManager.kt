package com.aleexalvz.sdk_user.data.user

import android.app.Activity
import android.content.Intent

object UserManager {

    const val logoutAction = "android.intent.action.SDK-USER-LOGOUT"

    private var loggedUser: User? = null

    fun login(user: User) {
        loggedUser = user
    }

    fun getLoggedUser(): User = loggedUser ?: throw UserException("Não há usuário logado")

    fun Activity.logout() {
        loggedUser = null
        startActivity(Intent(logoutAction))
    }
}