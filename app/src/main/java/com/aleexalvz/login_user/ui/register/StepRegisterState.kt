package com.aleexalvz.login_user.ui.register

sealed class StepRegisterState{
    object requiredInfo: StepRegisterState()
    object optionalInfo: StepRegisterState()
}
