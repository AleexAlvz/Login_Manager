package com.aleexalvz.login_manager.ui.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aleexalvz.login_manager.builder.LoginManager
import com.aleexalvz.login_manager.data.user.User
import com.aleexalvz.login_manager.data.user.UserException
import com.aleexalvz.login_manager.data.user.repository.LoginRepository
import com.aleexalvz.login_manager.data.user.repository.LoginRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel() : ViewModel() {

    private val repository: LoginRepository = LoginRepositoryImpl()

    private val _loginState = MutableStateFlow<LoginState>(LoginState.Successful)
    val uiLoginState: StateFlow<LoginState> = _loginState

    fun login(email: String, password: String) {
        viewModelScope.launch {
            try {
                val user: User = repository.login(email, password)
                LoginManager.login(user)
                _loginState.value = LoginState.Successful
            } catch (error: UserException) {
                Log.i("FAIL", "FAIL")
                _loginState.value = LoginState.Failure
            }
        }
    }

    sealed class LoginState {
        object Loading : LoginState()
        object Successful : LoginState()
        object Failure : LoginState()
    }
}
