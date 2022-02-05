package com.aleexalvz.login_manager.data.user

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val lastName: String,
    val email: String,
    val password: String,
    val numberPhone: Int? = null,
    val address: String? = null
)

class UserException(val error: String): Exception()
