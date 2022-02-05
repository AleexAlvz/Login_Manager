package com.aleexalvz.login_user.data.user.repository

import com.aleexalvz.login_user.data.user.User

interface RegisterRepository {
    fun insertUser(user: User)
}