package com.aleexalvz.login_manager.ui.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aleexalvz.login_manager.builder.LoginManager
import com.aleexalvz.login_manager.data.user.User
import com.aleexalvz.login_manager.data.user.UserException
import com.aleexalvz.login_manager.data.user.repository.LoginRepositoryImpl
import kotlinx.coroutines.launch

class LoginViewModel() : ViewModel() {

    private val repository = LoginRepositoryImpl()

    fun login(email: String, password: String) {
        viewModelScope.launch {
            try {
                val user: User = repository.login(email, password)
                LoginManager.onLoginSuccessful(user)
            } catch (error: UserException) {
                Log.i("FAIL","FAIL")
            }
        }
    }
}