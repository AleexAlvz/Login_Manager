package com.aleexalvz.login_manager.data.user.repository

import com.aleexalvz.login_manager.data.user.User
import com.aleexalvz.login_manager.data.user.UserDAO
import com.aleexalvz.login_manager.data.user.UserDatabase
import com.aleexalvz.login_manager.data.user.UserException

class RegisterRepositoryImpl() : RegisterRepository {

    val dao: UserDAO? by lazy { UserDatabase.Builder().getDB()?.dao }

    override fun insertUser(user: User) {
        try {
            dao!!.insertUser(user)
        } catch (error: Exception) {
            throw UserException("User is not valid")
        }
    }
}