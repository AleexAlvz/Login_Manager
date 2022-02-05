package com.aleexalvz.login_manager.ui.register

sealed class StepRegisterState{
    object requiredInfo: StepRegisterState()
    object optionalInfo: StepRegisterState()
}
