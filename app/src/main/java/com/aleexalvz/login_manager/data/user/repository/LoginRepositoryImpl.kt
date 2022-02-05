package com.aleexalvz.login_manager.data.user.repository

import com.aleexalvz.login_manager.CustomApplication
import com.aleexalvz.login_manager.builder.LoginManager
import com.aleexalvz.login_manager.data.user.*

class LoginRepositoryImpl() : LoginRepository {

    val dao = CustomApplication.getUserDB().dao

    override fun login(email: String, password: String): User {
        try {
            return dao.getUser(email, password)
        } catch (error: Exception) {
            throw UserException("User not found")
        }
    }
}