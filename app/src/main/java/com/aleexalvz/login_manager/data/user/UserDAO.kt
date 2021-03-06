package com.aleexalvz.login_manager.data.user

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.aleexalvz.login_manager.model.User

@Dao
interface UserDAO {

    @Query("SELECT * FROM User WHERE email = :email AND password = :password")
    fun getUser(email: String, password: String): User?

    @Insert
    fun insertUser(user: User)

    @Delete
    fun deleteUser(user: User)
}