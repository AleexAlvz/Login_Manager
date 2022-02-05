package com.aleexalvz.login_manager.data.user.repository

import com.aleexalvz.login_manager.data.user.User

interface LoginRepository {
    fun login(email: String, password: String): User
}