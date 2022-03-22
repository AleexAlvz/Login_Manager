package com.aleexalvz.login_manager.data.user.repository

import com.aleexalvz.login_manager.model.User
import com.aleexalvz.login_manager.data.user.UserDAO
import com.aleexalvz.login_manager.model.UserException

class RegisterRepositoryImpl(private val dao: UserDAO) : RegisterRepository {

    override fun insertUser(user: User) {
        try {
            dao.insertUser(user)
        } catch (error: Exception) {
            throw UserException("User is not valid")
        }
    }
}