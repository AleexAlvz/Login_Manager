package com.aleexalvz.sdk_user.data.user

class UserRepositoryImpl(private val dao: UserDAO) : UserRepository {

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

    override fun insertUser(user: User) {
        try {
            dao.insertUser(user)
        } catch (error: Exception) {
            throw UserException("User is not valid")
        }
    }
}