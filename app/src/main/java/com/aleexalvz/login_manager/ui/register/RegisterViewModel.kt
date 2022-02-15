package com.aleexalvz.login_manager.ui.register

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.*
import com.aleexalvz.login_manager.data.user.User
import com.aleexalvz.login_manager.data.user.UserDatabase
import com.aleexalvz.login_manager.data.user.repository.RegisterRepository
import com.aleexalvz.login_manager.data.user.repository.RegisterRepositoryImpl
import com.aleexalvz.login_manager.model.state.RegisterState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.flow.internal.ChannelFlow
import kotlinx.coroutines.launch

class RegisterViewModel(application: Application) : ViewModel() {

    private val repository: RegisterRepository

    private val _registerState = MutableLiveData<RegisterState>(RegisterState.Init)
    val uiRegisterState: LiveData<RegisterState> = _registerState

    init {
        val dao = UserDatabase.getInstance(application).dao
        repository = RegisterRepositoryImpl(dao)
    }

    fun registerUser(user: User) {
        CoroutineScope(IO).launch {
            try {
                _registerState.postValue(RegisterState.Loading)
                if (true) {
                    repository.insertUser(user)
                    _registerState.postValue(RegisterState.Successful)
                } else _registerState.postValue(RegisterState.Failure)
            } catch (error: Exception) {
                _registerState.postValue(RegisterState.Failure)
            }
        }
    }

    class Factory(val application: Application) : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>): T =
            RegisterViewModel(application) as T
    }
}