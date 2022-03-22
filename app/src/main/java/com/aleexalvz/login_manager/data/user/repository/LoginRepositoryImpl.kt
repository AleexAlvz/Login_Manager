package com.aleexalvz.login_manager.data.user.repository

import com.aleexalvz.login_manager.data.user.*
import com.aleexalvz.login_manager.model.User
import com.aleexalvz.login_manager.model.UserException

class LoginRepositoryImpl(private val dao: UserDAO) : LoginRepository {

    override fun login(email: String, password: String): User = dao.getUser(email, password) ?: throw UserException("User not found")
}