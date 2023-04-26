package com.thenexprojects.hiltexampleapplication.model.repo

import androidx.lifecycle.LiveData
import com.thenexprojects.hiltexampleapplication.data.MyRoomDatabase
import com.thenexprojects.hiltexampleapplication.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepositoryImpl(val db: MyRoomDatabase): UserRepository {
    override suspend fun addUser(user: User) {
        withContext(Dispatchers.IO){
            db.usersDao().insertUser(user)
        }
    }

    override fun getAllUsers(): LiveData<List<User>> {
        return db.usersDao().getAllUsers()
    }

    override suspend fun deleteUser(user: User) {
        withContext(Dispatchers.IO){
            db.usersDao().deleteUser(user)
        }
    }

    override suspend fun deleteUsers(users: List<User>) {
        withContext(Dispatchers.IO){
            db.usersDao().deleteUsers(users)
        }
    }
}