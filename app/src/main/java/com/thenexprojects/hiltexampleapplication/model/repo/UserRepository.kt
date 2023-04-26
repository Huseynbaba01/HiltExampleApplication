package com.thenexprojects.hiltexampleapplication.model.repo

import androidx.lifecycle.LiveData
import com.thenexprojects.hiltexampleapplication.model.User

interface UserRepository {

    fun getAllUsers(): LiveData<List<User>>

    suspend fun addUser(user: User)

    suspend fun deleteUser(user: User)

    suspend fun deleteUsers(users: List<User>)

}