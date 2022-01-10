package com.aleexalvz.sdk_user.data.user

interface UserRepository {
    fun login(email: String, password: String): User
    fun insertUser(user: User)
}