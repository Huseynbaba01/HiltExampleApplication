package com.thenexprojects.hiltexampleapplication.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.thenexprojects.hiltexampleapplication.model.User
import javax.inject.Inject

@Database(entities = [User::class], version = 1)
abstract class MyRoomDatabase: RoomDatabase() {
    abstract fun usersDao(): UsersDao
}