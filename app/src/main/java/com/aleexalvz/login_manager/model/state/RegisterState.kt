package com.aleexalvz.login_manager.model.state

sealed class RegisterState {
    object Init : RegisterState()
    object Successful : RegisterState()
    object Loading: RegisterState()
    object Failure : RegisterState()
}
