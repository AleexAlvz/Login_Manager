package com.aleexalvz.login_manager.ui.register

import androidx.lifecycle.ViewModel
import com.aleexalvz.login_manager.data.user.User
import com.aleexalvz.login_manager.data.user.repository.RegisterRepository
import com.aleexalvz.login_manager.data.user.repository.RegisterRepositoryImpl

class RegisterViewModel : ViewModel() {

    private val repository: RegisterRepository = RegisterRepositoryImpl()

    fun registerUser(user: User) {
        if (true){
            repository.insertUser(user)
        }
    }
}