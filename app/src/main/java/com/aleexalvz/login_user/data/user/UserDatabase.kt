package com.aleexalvz.login_user.data.user

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [User::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract val dao: UserDAO
}