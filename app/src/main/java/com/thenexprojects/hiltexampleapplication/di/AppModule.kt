package com.thenexprojects.hiltexampleapplication.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.thenexprojects.hiltexampleapplication.data.MyRoomDatabase
import com.thenexprojects.hiltexampleapplication.data.UsersDao
import com.thenexprojects.hiltexampleapplication.di.qualifiers.FirstUserRepository
import com.thenexprojects.hiltexampleapplication.di.qualifiers.SecondUserRepository
import com.thenexprojects.hiltexampleapplication.model.repo.UserRepository
import com.thenexprojects.hiltexampleapplication.model.repo.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.FragmentScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    @FirstUserRepository
    fun provideRepository(dao: UsersDao): UserRepository {
        return UserRepositoryImpl(dao)
    }

    @Provides
    @Singleton
    @SecondUserRepository
    fun provideSecondRepository(dao: UsersDao): UserRepository {
        return UserRepositoryImpl(dao)
    }

    @Provides
    fun provideUsersDao(roomDb: MyRoomDatabase): UsersDao{
        return roomDb.usersDao()
    }

    @Provides
    fun provideMyRoomDatabase(@ApplicationContext context: Context): MyRoomDatabase{
        return Room.databaseBuilder(context, MyRoomDatabase::class.java, "my_database").build()
    }

    @Provides
    fun provideContext(@ActivityContext context: Context): Context{
        return context
    }

}