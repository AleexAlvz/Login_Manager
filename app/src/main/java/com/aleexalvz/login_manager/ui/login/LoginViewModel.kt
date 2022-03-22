package com.aleexalvz.login_manager.ui.login

import android.app.Application
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aleexalvz.login_manager.builder.LoginManager
import com.aleexalvz.login_manager.data.user.UserDatabase
import com.aleexalvz.login_manager.model.UserException
import com.aleexalvz.login_manager.data.user.repository.LoginRepository
import com.aleexalvz.login_manager.data.user.repository.LoginRepositoryImpl
import com.aleexalvz.login_manager.model.state.LoginState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel private constructor(val application: Application) : ViewModel() {

    private val repository: LoginRepository

    init {
        val dao = UserDatabase.getInstance(application).dao
        repository = LoginRepositoryImpl(dao)
    }

    private val _loginState = MutableStateFlow<LoginState>(LoginState.Init)
    val uiLoginState: StateFlow<LoginState> = _loginState

    fun login(email: String, password: String) {
        CoroutineScope(IO).launch {
            try {
                _loginState.value = LoginState.Loading
                val user = repository.login(email, password)
                LoginManager.login(application.applicationContext, user)
                _loginState.value = LoginState.Successful
            } catch (error: UserException) {
                Log.i("FAIL", "FAIL")
                _loginState.value = LoginState.Failure
            }
        }
    }

    class Factory(val application: Application) : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>): T =
            LoginViewModel(application) as T
    }
}

