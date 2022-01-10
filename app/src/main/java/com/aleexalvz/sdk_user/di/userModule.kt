package com.aleexalvz.sdk_user.di

import androidx.room.Room
import com.aleexalvz.sdk_user.data.user.UserDAO
import com.aleexalvz.sdk_user.data.user.UserDatabase
import com.aleexalvz.sdk_user.data.user.UserRepository
import com.aleexalvz.sdk_user.data.user.UserRepositoryImpl
import com.aleexalvz.sdk_user.ui.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val userModule = module {
    viewModel { LoginViewModel(get<UserRepository>()) }

    single<UserRepository> { UserRepositoryImpl(get<UserDAO>()) }
    single<UserDAO> { get<UserDatabase>().dao }
    single<UserDatabase> { Room.databaseBuilder(get(), UserDatabase::class.java, "user_db").build() }
}