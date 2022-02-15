package com.aleexalvz.login_manager.data.user.repository

import com.aleexalvz.login_manager.data.user.*

class LoginRepositoryImpl(private val dao: UserDAO) : LoginRepository {

    override fun login(email: String, password: String): User = dao.getUser(email, password) ?: throw UserException("User not found")
}