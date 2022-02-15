package com.aleexalvz.login_manager.model.state

sealed class LoginState{
    object Init: LoginState()
    object Loading : LoginState()
    object Successful : LoginState()
    object Failure : LoginState()
}
