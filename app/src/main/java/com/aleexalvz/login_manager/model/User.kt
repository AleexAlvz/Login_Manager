package com.aleexalvz.login_manager.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class User(
    val name: String,
    val email: String,
    val password: String,
    val numberPhone: String? = null,
    val address: String? = null,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)

class UserException(val error: String): Exception()
