package com.aleexalvz.login_user.data.user.repository

import com.aleexalvz.login_user.data.user.User
import com.aleexalvz.login_user.data.user.UserDAO
import com.aleexalvz.login_user.data.user.UserException

class RegisterRepositoryImpl(
    private val dao: UserDAO
) : RegisterRepository {

    override fun insertUser(user: User) {
        try {
            dao.insertUser(user)
        } catch (error: Exception) {
            throw UserException("User is not valid")
        }
    }
}