package com.aleexalvz.login_user.data.user.repository

import com.aleexalvz.login_user.data.user.User

interface LoginRepository {
    fun login(email: String, password: String): User
}