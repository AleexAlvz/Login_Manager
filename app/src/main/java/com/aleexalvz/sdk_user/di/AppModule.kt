package com.aleexalvz.sdk_user.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.aleexalvz.sdk_user.data.user.UserDatabase
import com.aleexalvz.sdk_user.data.user.UserRepository
import com.aleexalvz.sdk_user.data.user.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
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
    fun providesUserRepository(db: UserDatabase): UserRepository {
        return UserRepositoryImpl(db.dao)
    }

}