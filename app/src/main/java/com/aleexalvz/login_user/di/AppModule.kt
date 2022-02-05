package com.aleexalvz.login_user.di

import android.app.Application
import androidx.room.Room
import com.aleexalvz.login_user.data.user.UserDatabase
import com.aleexalvz.login_user.data.user.repository.LoginRepository
import com.aleexalvz.login_user.data.user.repository.LoginRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesUserDatabase(app: Application): UserDatabase {
        return Room.databaseBuilder(
            app,
            UserDatabase::class.java,
            "user_db"
        ).build()
    }

    @Provides
    @Singleton
    fun providesUserRepository(db: UserDatabase): LoginRepository {
        return LoginRepositoryImpl(db.dao)
    }

}