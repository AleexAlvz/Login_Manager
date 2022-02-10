package com.aleexalvz.login_manager

import android.app.Application
import android.content.Context

class LoginApplication : Application() {
    companion object{
        var appContext: Context? = null
    }
}