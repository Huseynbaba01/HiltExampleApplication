package com.thenexprojects.hiltexampleapplication.di

import android.content.Context
import androidx.room.Room
import com.thenexprojects.hiltexampleapplication.data.MyRoomDatabase
import com.thenexprojects.hiltexampleapplication.data.UsersDao
import com.thenexprojects.hiltexampleapplication.model.repo.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.FragmentScoped
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Provides
    fun provideUserRepository(usersDao: UsersDao): UserRepositoryImpl{
        return UserRepositoryImpl(usersDao)
    }

    @Provides
    fun provideUsersDao(myRoomDB: MyRoomDatabase): UsersDao{
        return myRoomDB.usersDao()
    }

    @Provides
    fun provideMyRoomDatabase(@ApplicationContext context: Context): MyRoomDatabase{
        return Room.databaseBuilder(context,MyRoomDatabase::class.java, "my_db").build()
    }
}