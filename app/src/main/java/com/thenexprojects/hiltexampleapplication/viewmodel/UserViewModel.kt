package com.thenexprojects.hiltexampleapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.thenexprojects.hiltexampleapplication.data.MyRoomDatabase
import com.thenexprojects.hiltexampleapplication.model.User
import com.thenexprojects.hiltexampleapplication.model.repo.UserRepositoryImpl
import kotlinx.coroutines.launch

class UserViewModel(application: Application): AndroidViewModel(application) {
    private val userRepo = UserRepositoryImpl(MyRoomDatabase.getInstance((getApplication() as Application).applicationContext))

    fun getAllUsers(): LiveData<List<User>>{
        return userRepo.getAllUsers()
    }

    fun addUser(user: User){
        viewModelScope.launch {
            userRepo.addUser(user)
        }
    }
    fun deleteUser(user: User){
        viewModelScope.launch {
            userRepo.deleteUser(user)
        }
    }
    fun deleteUsers(users: List<User>){
        viewModelScope.launch {
            userRepo.deleteUsers(users)
        }
    }

}