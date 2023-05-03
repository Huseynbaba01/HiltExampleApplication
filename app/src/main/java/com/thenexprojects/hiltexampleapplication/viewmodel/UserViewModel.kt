package com.thenexprojects.hiltexampleapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.thenexprojects.hiltexampleapplication.data.MyRoomDatabase
import com.thenexprojects.hiltexampleapplication.model.User
import com.thenexprojects.hiltexampleapplication.model.repo.UserRepository
import com.thenexprojects.hiltexampleapplication.model.repo.UserRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(application: Application, val userRepo: UserRepositoryImpl): AndroidViewModel(application) {

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