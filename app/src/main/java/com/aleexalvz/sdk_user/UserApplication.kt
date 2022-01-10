package com.aleexalvz.sdk_user

import android.app.Application
import com.aleexalvz.sdk_user.di.userModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class UserApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@UserApplication)
            modules(userModule)
        }
    }
}