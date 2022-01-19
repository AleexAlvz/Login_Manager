package com.aleexalvz.sdk_user.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aleexalvz.sdk_user.data.user.User
import com.aleexalvz.sdk_user.data.user.UserException
import com.aleexalvz.sdk_user.data.user.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: UserRepository
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