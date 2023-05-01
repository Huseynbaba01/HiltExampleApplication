package com.thenexprojects.hiltexampleapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.thenexprojects.hiltexampleapplication.di.qualifiers.SecondUserRepository
import com.thenexprojects.hiltexampleapplication.model.User
import com.thenexprojects.hiltexampleapplication.model.repo.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class UserViewModel @Inject constructor(application: Application, @SecondUserRepository private val userRepo: UserRepository): AndroidViewModel(application) {

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