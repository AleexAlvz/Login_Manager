package com.aleexalvz.login_manager.data.user.repository

import com.aleexalvz.login_manager.CustomApplication
import com.aleexalvz.login_manager.data.user.*

class LoginRepositoryImpl() : LoginRepository {

    val dao = CustomApplication.getUserDB().dao

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