package com.aleexalvz.login_user.data.user.repository

import com.aleexalvz.login_user.data.user.User
import com.aleexalvz.login_user.data.user.UserDAO
import com.aleexalvz.login_user.data.user.UserException
import com.aleexalvz.login_user.data.user.UserManager

class LoginRepositoryImpl(
    private val dao: UserDAO
) : LoginRepository {

    override fun login(email: String, password: String): User {
        try {
            dao.getUser(email, password).let { user ->
                UserManager.login(user)
                return user
            }
        } catch (error: Exception) {
            throw UserException("User not found")
        }
    }
}