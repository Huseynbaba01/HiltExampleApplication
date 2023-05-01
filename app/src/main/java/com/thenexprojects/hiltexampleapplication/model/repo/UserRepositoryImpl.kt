package com.thenexprojects.hiltexampleapplication.model.repo

import android.util.Log
import androidx.lifecycle.LiveData
import com.thenexprojects.hiltexampleapplication.data.MyRoomDatabase
import com.thenexprojects.hiltexampleapplication.data.UsersDao
import com.thenexprojects.hiltexampleapplication.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepositoryImpl(val usersDao: UsersDao): UserRepository {
    override suspend fun addUser(user: User) {
        withContext(Dispatchers.IO){
            usersDao.insertUser(user)
        }
    }

    override fun getAllUsers(): LiveData<List<User>> {
        return usersDao.getAllUsers()
    }

    override suspend fun deleteUser(user: User) {
        withContext(Dispatchers.IO){
            usersDao.deleteUser(user)
        }
    }

    override suspend fun deleteUsers(users: List<User>) {
        withContext(Dispatchers.IO){
            usersDao.deleteUsers(users)
        }
    }
}