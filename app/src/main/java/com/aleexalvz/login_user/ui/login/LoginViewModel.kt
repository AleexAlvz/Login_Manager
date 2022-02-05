package com.aleexalvz.login_user.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aleexalvz.login_user.data.user.User
import com.aleexalvz.login_user.data.user.UserException
import com.aleexalvz.login_user.data.user.repository.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: LoginRepository
) : ViewModel() {

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