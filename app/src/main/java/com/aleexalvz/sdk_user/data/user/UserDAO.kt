package com.aleexalvz.sdk_user.data.user

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDAO {

    @Query("SELECT * FROM User WHERE email = :email AND password = :password")
    fun getUser(email: String, password: String): User

    @Insert
    fun insertUser(user: User)

    @Delete
    fun deleteUser(user: User)
}