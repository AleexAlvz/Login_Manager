package com.aleexalvz.sdk_user.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aleexalvz.sdk_user.data.user.User
import com.aleexalvz.sdk_user.data.user.UserException
import com.aleexalvz.sdk_user.data.user.UserRepository
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: UserRepository) : ViewModel() {

    fun login(email: String, password: String) {
        viewModelScope.launch {
            try {
                val user: User = repository.login(email, password)
                TODO()
            } catch (error: UserException) {
                TODO()
            }
        }
    }
}