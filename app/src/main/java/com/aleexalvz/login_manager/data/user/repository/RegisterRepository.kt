package com.aleexalvz.login_manager.data.user.repository

import com.aleexalvz.login_manager.data.user.User

interface RegisterRepository {
    fun insertUser(user: User)
}